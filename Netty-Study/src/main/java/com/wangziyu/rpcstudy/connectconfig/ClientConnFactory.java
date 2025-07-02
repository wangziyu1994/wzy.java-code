package com.wangziyu.rpcstudy.connectconfig;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ClientConnFactory {
    int poolSize = 10;
    NioEventLoopGroup selectorGroup;
    Random random = new Random();
    private static final ClientConnFactory clientConnFactory;

    private ClientConnFactory() {
    }

    static {
        clientConnFactory = new ClientConnFactory();
    }

    public static ClientConnFactory getClientFactory() {
        return clientConnFactory;
    }

    public ConcurrentHashMap<InetSocketAddress, ClientConnPool> connectPoolMap = new ConcurrentHashMap<>();


    public synchronized NioSocketChannel getClientSocket(InetSocketAddress address) throws InterruptedException {
        ClientConnPool clientConnPool = connectPoolMap.get(address);
        if (clientConnPool == null) {
            System.out.println("连接池开始初始化....");
            connectPoolMap.putIfAbsent(address, new ClientConnPool(poolSize));
            clientConnPool = connectPoolMap.get(address);
        }

        int clientIndex = random.nextInt(poolSize);
        boolean newFlag=clientConnPool.clientSockets[clientIndex] == null;
        if(!newFlag){
            System.out.println(clientIndex+"连接活跃状态:"+String.valueOf( clientConnPool.clientSockets[clientIndex].isActive()));
        }else{
            System.out.println(clientIndex+"连接为空");
        }
        if (clientConnPool.clientSockets[clientIndex] != null && clientConnPool.clientSockets[clientIndex].isActive()) {
            System.out.println("成功获取活跃连接"+clientIndex);
            return clientConnPool.clientSockets[clientIndex];
        }

        //用锁同步保证只会创建唯一一个连接
        synchronized (clientConnPool.locks[clientIndex]) {
          clientConnPool.clientSockets[clientIndex] = createClientSocketByNetty(address);
        }
        return clientConnPool.clientSockets[clientIndex];


    }

    public NioSocketChannel createClientSocketByNetty(InetSocketAddress address) throws InterruptedException {
        System.out.println("创建新的连接...");
        this.selectorGroup = new NioEventLoopGroup(5);
        Bootstrap bootStrap = new Bootstrap();
        bootStrap.group(selectorGroup);
        bootStrap.channel(NioSocketChannel.class);
        bootStrap.handler(new ChannelInitializer<NioSocketChannel>() {
          @Override
          protected void initChannel(NioSocketChannel channel) throws Exception {
            ChannelPipeline channelPipeline=channel.pipeline();
              channelPipeline.addLast(new ClientDecodeHandler());
            channelPipeline.addLast(new ReadFromServerHandler());
            System.out.println("Inithandler开始分发处理器");
          }
        });
      ChannelFuture channelFuture=bootStrap.connect(address);
        System.out.println("创建新的连接成功");
        return (NioSocketChannel) channelFuture.sync().channel();
    }


}
