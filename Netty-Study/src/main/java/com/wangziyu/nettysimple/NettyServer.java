package com.wangziyu.nettysimple;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;


public class NettyServer {
    public static final String localhost="localhost";
    public static final String remotehost="192.168.147.129";
    public static final int port=1200;

    public static void main(String[] args) throws InterruptedException {
          initNettyServer();
    }

    public static void initNettyServer() throws InterruptedException {
        //创建netty server 服务端
        NioEventLoopGroup selectorGroup=new NioEventLoopGroup(1);

        //创建Netty 服务端socket
        NioServerSocketChannel server=new NioServerSocketChannel();
        //服务端注册selector
        selectorGroup.register(server);
        //提前设置事件处理器
        ChannelPipeline pipeline=server.pipeline();
        pipeline.addLast(new ServerAcceptHandler(new DispatcherHandler(),selectorGroup));
        System.out.println(Thread.currentThread().getName()+" 开始监听端口...");
        ChannelFuture bindFuture=server.bind(new InetSocketAddress(localhost,port));


        bindFuture.sync().channel().closeFuture().sync();

    }


   static class ServerAcceptHandler extends ChannelInboundHandlerAdapter {
        private DispatcherHandler dispatcherHandler;
        private NioEventLoopGroup selectorGroup;

       public ServerAcceptHandler(DispatcherHandler dispatcherHandler,NioEventLoopGroup selectorGroup) {
           this.selectorGroup=selectorGroup;
           this.dispatcherHandler = dispatcherHandler;
       }

       @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
          System.out.println(Thread.currentThread().getName()+" 开始调用server accept Handler处理器");
        }

       @Override
       public void channelActive(ChannelHandlerContext ctx) throws Exception {
           System.out.println("accept Handler检测通道处于活跃状态....");
       }

       @Override
       public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
           System.out.println(Thread.currentThread().getName()+" 开始调用server accept Handler处理器");
          // System.out.println(msg.getClass());
           SocketChannel client=(SocketChannel)msg;
           ChannelPipeline pipeline=client.pipeline();
           System.out.println(Thread.currentThread().getName()+" server accept Handler注册read Handler到接收的client");
           pipeline.addLast(dispatcherHandler);
           System.out.println(Thread.currentThread().getName()+" client注册selector");
           selectorGroup.register(client);



       }
   }


   static class ServerReadHandler extends  ChannelInboundHandlerAdapter{
       @Override
       public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
           System.out.println(Thread.currentThread().getName()+" 开始调用server read Handler处理器");
       }

       @Override
       public void channelActive(ChannelHandlerContext ctx) throws Exception {
           System.out.println("read Handler检测通道处于活跃状态....");
       }

       @Override
       public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
           System.out.println(Thread.currentThread().getName()+" 开始调用server read Handler处理器");


           ByteBuf recieveMsg=(ByteBuf)msg;
           CharSequence charSequence=recieveMsg.getCharSequence(0,recieveMsg.readableBytes(), CharsetUtil.UTF_8);
           System.out.println("netty服务端接收到消息:["+charSequence+"]");



           System.out.println("netty服务端发送接收到的消息["+charSequence.toString()+"]");
           ctx.writeAndFlush(recieveMsg);



       }



   }


   //定义一个Handler专门用户分发事件给其他Handler,且被所有事件所共享
   @ChannelHandler.Sharable
   static class DispatcherHandler extends ChannelInboundHandlerAdapter {

       @Override
       public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
           System.out.println("dispatchHandler被注册");
           Thread.sleep(1500);
           System.out.println("diaptchHander 开始分发其他Handler");
           Channel client=ctx.channel();
           ChannelPipeline channelPipeline=client.pipeline();
           channelPipeline.addLast(new ServerReadHandler());




       }


   }


}
