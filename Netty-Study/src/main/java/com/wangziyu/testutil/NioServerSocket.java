package com.wangziyu.testutil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioServerSocket {
    public static final String localhost="127.0.0.1";
    public static final String remotehost="192.168.147.1";
    public static boolean serverAcceptBlock = false;
    public static boolean readSocketBlock = false;

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel server = initNioServerSocket();
        boolean flag = true;
        while (flag) {
            Thread.sleep(1000);
            SocketChannel socket = server.accept();
            if (socket != null) {
                System.out.println("accept port:" + socket.socket().getPort() + "success");
                initNioClientSocket(socket);
                processSocket(socket);
            } else {
                //System.out.println("not accept clientsocket!");
            }

        }
    }


    public static ServerSocketChannel initNioServerSocket() throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress lisenPort = new InetSocketAddress(localhost, 1200);
        server.bind(lisenPort);
        server.configureBlocking(serverAcceptBlock);
        System.out.println("server port:["+1200+"]start");
        return server;

    }

    public static void initNioClientSocket(SocketChannel socketChannel) throws IOException {
        socketChannel.configureBlocking(readSocketBlock);


    }


    public static void processSocket(SocketChannel socketChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        int num = socketChannel.read(byteBuffer);
        if (num > 0) {
            byte[] receiveMessage = new byte[byteBuffer.limit()];
            byteBuffer.get(receiveMessage);
            String str = new String(receiveMessage);
            System.out.println("receive message" + str);
            byteBuffer.clear();
        } else {
            System.out.println("not receive message");
        }
    }

}
