package com.wangziyu.testutil;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class SocketClientMutipleThread {
    public static final List<SocketChannel> clientSocketList1 = new ArrayList();
    public static final List<SocketChannel> clientSocketList2 = new ArrayList();
    public static final InetSocketAddress remoteServer = new InetSocketAddress("192.168.147.129", 1200);
    public static final InetSocketAddress localServer = new InetSocketAddress("127.0.0.1", 1200);
    public static final int size = 20000;

    public static void main(String[] args) throws IOException {
        //getLocalIp();
        //initClilentList1();
        initClilentList2();
        System.out.println(clientSocketList1.size());
        System.out.println(clientSocketList2.size());
        System.in.read();
    }


    public static void initClilentList1() throws IOException {


        for (int port = 10000; port <= size; port++) {
            //SocketChannel client1 = SocketChannel.open();
            SocketChannel client2 = SocketChannel.open();

            //InetSocketAddress source1 = new InetSocketAddress("192.168.43.110", port);
            InetSocketAddress source2 = new InetSocketAddress("192.168.147.1", port);

          /*  client1.bind(source1);
            client1.connect(remoteServer);
            System.out.println("client1" + port + "connect success");*/

            client2.bind(source2);
            client2.connect(remoteServer);
            System.out.println("client2:" + port + "connect success");

           // clientSocketList1.add(client1);
            clientSocketList2.add(client2);
        }
    }


    public static void initClilentList2() throws IOException {


        for (int port = 10000; port <= size; port++) {
            SocketChannel client1 = SocketChannel.open();

            InetSocketAddress source1 = new InetSocketAddress("192.168.43.110", port);


            client1.bind(source1);
            client1.connect(remoteServer);
            System.out.println("client1" + port + "connect success");



             clientSocketList1.add(client1);

        }
    }

    public static void getLocalIp() throws UnknownHostException {
        InetAddress inet4Address=Inet4Address.getLocalHost();
        String ip4=inet4Address.getHostAddress();
        System.out.println(ip4);
    }
}
