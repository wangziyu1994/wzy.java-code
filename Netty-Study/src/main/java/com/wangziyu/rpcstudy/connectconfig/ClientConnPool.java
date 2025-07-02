package com.wangziyu.rpcstudy.connectconfig;

import io.netty.channel.socket.nio.NioSocketChannel;

public class ClientConnPool {
  public  NioSocketChannel[] clientSockets;
    public Object[] locks;

    public ClientConnPool(int size) {
        this.clientSockets = new NioSocketChannel[size];
        this.locks = new Object[size];
        for(int i=0;i<size;i++){
           locks[i]=new Object();
        }
        System.out.println("第一个连接为"+clientSockets[0]);
    }

}
