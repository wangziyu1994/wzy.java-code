package com.wangziyu.nettysimple;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class NettyClientWrapper {
    public static final String localhost="localhost";
    public static final String remotehost="192.168.147.129";
    public static final int port=1200;
    public static void main(String[] args) throws InterruptedException {
        initNettyClient();
    }


    public static void initNettyClient() throws InterruptedException {
        //创建selectorGroup
        NioEventLoopGroup selectorGroup=new NioEventLoopGroup(1);
        Bootstrap bootStrap=new Bootstrap();
        bootStrap.group(selectorGroup);
        bootStrap.channel(NioSocketChannel.class);
        bootStrap.handler(new MyHandlerInitializer());
        ChannelFuture connectFuture=bootStrap.connect(new InetSocketAddress(localhost,port));


        ByteBuf byteBuf= ByteBufAllocator.DEFAULT.directBuffer(30,50);
        byteBuf.writeBytes("netty客户端connect".getBytes());
        Channel client=connectFuture.channel();
        client.writeAndFlush(byteBuf);






        //writeFuture.sync();
        // connect.channel().closeFuture().sync();
        //ChannelFuture res=channelFuture.sync();

    }



    static class  MyHandlerInitializer extends ChannelInitializer<NioSocketChannel> {

        @Override
        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
            ChannelPipeline channelPipeline=nioSocketChannel.pipeline();
            channelPipeline.addLast(new MyReadHandler());
        }
    }


    static class MyReadHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println("自定义读处理器被注册");
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
