package com.wangziyu.rpcstudy.consumer;

import com.wangziyu.rpcstudy.connectconfig.NettyHttpServerResHandler;
import com.wangziyu.rpcstudy.connectconfig.ServiceDispatcher;
import com.wangziyu.rpcstudy.service.Order;
import com.wangziyu.rpcstudy.serviceimpl.OrderService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.io.IOException;
import java.net.InetSocketAddress;

public class NettyHttpProvider {
    public static final String localhost="localhost";
    public static final String remotehost="192.168.147.129";
    public static final int port=1200;


    public static void main(String[] args) throws InterruptedException, IOException {
        startHttpProvider();
    }


    public static  void startHttpProvider() throws InterruptedException {
        InetSocketAddress serverInet=new InetSocketAddress(localhost,port);
        NioEventLoopGroup selectGroup=new NioEventLoopGroup(10);
        NioEventLoopGroup workerGroup=new NioEventLoopGroup(10);
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        Order orderService=new OrderService(Order.class.getName());
        ServiceDispatcher serviceDispatcher=new ServiceDispatcher();
        serviceDispatcher.registerService(orderService);



        serverBootstrap.group(selectGroup,workerGroup);
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel clientChannel) throws Exception {
                ChannelPipeline channelPipeline=clientChannel.pipeline();
                channelPipeline.addLast(new HttpServerCodec());
                channelPipeline.addLast(new HttpObjectAggregator(1024*512));
                channelPipeline.addLast(new NettyHttpServerResHandler());
                System.out.println("Http服务端开始分发处理器");
            }
        });
        ChannelFuture channelFuture=serverBootstrap.bind(serverInet);
      //  channelFuture.sync().channel().closeFuture().sync();
        System.out.println("Http服务端启动完成...");
    }
}
