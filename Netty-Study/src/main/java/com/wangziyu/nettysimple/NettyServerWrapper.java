package com.wangziyu.nettysimple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

public class NettyServerWrapper {
    public static final String localhost="localhost";
    public static final String remotehost="192.168.147.129";
    public static final int port=1200;

    public static void main(String[] args) throws InterruptedException {
        initNettyServer();
    }

    public static void initNettyServer() throws InterruptedException {
        //创建netty server 服务端
        NioEventLoopGroup selectorGroup=new NioEventLoopGroup(1);
        ServerBootstrap serverBootStrap=new ServerBootstrap();
        serverBootStrap.group(selectorGroup,selectorGroup);
        serverBootStrap.channel(NioServerSocketChannel.class);
        serverBootStrap.childHandler(new MyHandlerInitializer());

        ChannelFuture channelFuture= serverBootStrap.bind(new InetSocketAddress(localhost,port));


    }


    static class MyHandlerInitializer extends ChannelInitializer<NioSocketChannel>{

        @Override
        protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
            System.out.println("进入自定义处理器初始化");
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
            System.out.println("自定义读处理器被调用");
            System.out.println(Thread.currentThread().getName()+" 开始调用server read Handler处理器");
            ByteBuf recieveMsg=(ByteBuf)msg;
            CharSequence charSequence=recieveMsg.getCharSequence(0,recieveMsg.readableBytes(), CharsetUtil.UTF_8);
            System.out.println("netty服务端接收到消息:["+charSequence+"]");
            System.out.println("netty服务端发送接收到的消息["+charSequence.toString()+"]");
            ctx.writeAndFlush(recieveMsg);
        }
    }



}
