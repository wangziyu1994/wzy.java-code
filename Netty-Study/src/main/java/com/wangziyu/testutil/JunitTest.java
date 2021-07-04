package com.wangziyu.testutil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import org.junit.Test;

import java.net.InetSocketAddress;

public class JunitTest {
    @Test
    public void clientMode() throws Exception {
        NioEventLoopGroup thread = new NioEventLoopGroup(1);

        //客户端模式：
        NioSocketChannel client = new NioSocketChannel();

        thread.register(client);  //epoll_ctl(5,ADD,3)

        //响应式：
        ChannelPipeline p = client.pipeline();
        p.addLast(new MyInHandler());

        //reactor  异步的特征
        ChannelFuture connect = client.connect(new InetSocketAddress("localhost", 1200));
        ChannelFuture sync = connect.sync();

        ByteBuf buf = Unpooled.copiedBuffer("hello server".getBytes());
        ChannelFuture send = client.writeAndFlush(buf);
        send.sync();

        //马老师的多线程
        sync.channel().closeFuture().sync();

        System.out.println("client over....");

    }

    class MyInHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("client  registed...");
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("client active...");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf) msg;
//        CharSequence str = buf.readCharSequence(buf.readableBytes(), CharsetUtil.UTF_8);
            CharSequence str = buf.getCharSequence(0, buf.readableBytes(), CharsetUtil.UTF_8);
            System.out.println(str);
            ctx.writeAndFlush(buf);
        }

    }
}
