package com.wangziyu.nettysimple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class NettyClient {
    public static final String localhost="localhost";
    public static final String remotehost="192.168.147.129";
    public static final int port=1200;
    public static void main(String[] args) throws InterruptedException {
        initNettyClient();
    }


    public static void initNettyClient() throws InterruptedException {
        //创建selectorGroup
        NioEventLoopGroup selectorGroup=new NioEventLoopGroup(1);
        //创建客户端socket
        NioSocketChannel client=new NioSocketChannel();


         //向selectorGroup注册连接
        selectorGroup.register(client);
        System.out.println("netty客户端创建完成");


        //netty是Reactor  异步响应式的，所以必须提前注册处理器。等触发相应事件回调.
        ChannelPipeline channelPipeline=client.pipeline();
        channelPipeline.addLast(new ClientHandler());

        //线程异步取建立连接，所以必须阻塞住获取结果
        ChannelFuture channelFuture=client.connect(new InetSocketAddress(localhost,port));
        System.out.println("netty客户端异步建立连接");
        //ChannelFuture connect=channelFuture.sync();


        ByteBuf byteBuf= ByteBufAllocator.DEFAULT.directBuffer(30,50);
        byteBuf.writeBytes("netty客户端connect".getBytes());
        ChannelFuture writeFuture=client.writeAndFlush(byteBuf);


        //writeFuture.sync();

       // connect.channel().closeFuture().sync();
       //ChannelFuture res=channelFuture.sync();

    }



    static class ClientHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println(Thread.currentThread().getName()+"  client readHandler被注册");
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channel是活跃的...");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(Thread.currentThread().getName()+"  client开始处理read事件");
            ByteBuf byteBuf=(ByteBuf)msg;
            byte[] bytes=new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            String receieveMsgs=new String(bytes);
            System.out.println("客户端 receieve msg["+receieveMsgs+"]");

        }
    }
}
