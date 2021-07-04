package com.wangziyu.rpcstudy.consumer;

import com.wangziyu.rpcstudy.connectconfig.MyHttpServerResHandler;
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
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class MyHttpProvider {
    public static final String localhost="localhost";
    public static final String remotehost="192.168.147.129";
    public static final int port=1200;


    public static void main(String[] args) throws Exception {
        startHttpProvider();
    }


    public static  void startHttpProvider() throws Exception {
        InetSocketAddress serverInet=new InetSocketAddress(localhost,port);
        Server httpserver=new Server(serverInet);
         ServletContextHandler servletContextHandler=new ServletContextHandler(httpserver,"/");
         httpserver.setHandler(servletContextHandler);
         servletContextHandler.addServlet(MyHttpServerResHandler.class,"/*");
         httpserver.start();
         httpserver.join();

        System.out.println("Http服务端启动完成...");
    }
}
