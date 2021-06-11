package com.wangziyu.linuxiostudy.biostudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class BioServerSocket {
    //server properties
    public static final int serverPort=1200;
    public static final int BACK_LOG=2;
    public static boolean REUSE_ADDR=false;
    public static final int SO_TIMEOUT=0;

    //client properties
    public static boolean CLI_KEEPALIVE=false;
    public static boolean CLI_OOB=false;
    public static int CLI_REC_BUF=20;
    public static boolean CLI_REUSE_ADDR=false;
    public static int CLI_SEND_BUF=20;
    public static boolean CLI_LINGER=false;
    public static int CLI_LINGER_N=0;
    public static int CLI_TIMEOUT=0;
    public static boolean CLI_NO_DELAY=false;

    public static void main(String[] args) throws IOException {
      SocketServerStart();
    }


    public static void SocketServerStart() throws IOException {


        ServerSocket serverSocket=new ServerSocket();
        serverInit(serverSocket);
        System.out.println("bio server start!  port:"+serverPort);
        System.in.read();

       while (true){

           //如果一直没有请求，它是阻塞的。
           System.out.println("bio server accept ......");
           Socket  clientSocket=serverSocket.accept();
           System.out.println("client port"+clientSocket.getPort()+" connected to myserver");
           clientInit(clientSocket);

           Thread readThread=new Thread(()->{
               try {
                   InputStream inputStream=clientSocket.getInputStream();
                   InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
                   BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                   char[] data=new char[1024];
                   while(true){
                       int num=bufferedReader.read(data);
                       if(num>0){
                           System.out.println("client read some data is :" + num + " val :" + new String(data, 0, num));
                       }else if(num==0){
                         System.out.println("client read nothing");
                       }
                       else {
                           System.out.println("client read -1");
                           System.in.read();
                           clientSocket.close();
                           break;
                       }
                   }

               } catch (IOException e) {
                   e.printStackTrace();
               }

           });


           readThread.start();

       }
    }


    public static void serverInit(ServerSocket serverSocket) throws IOException {
        InetSocketAddress socketAddress=new InetSocketAddress(serverPort);
        serverSocket.bind(socketAddress,BACK_LOG);
        serverSocket.setReuseAddress(REUSE_ADDR);
        serverSocket.setSoTimeout(SO_TIMEOUT);
    }

    public static void clientInit(Socket client) throws SocketException {
       client.setKeepAlive(CLI_KEEPALIVE);
       client.setOOBInline(CLI_OOB);
       client.setReceiveBufferSize(CLI_REC_BUF);
       client.setReuseAddress(CLI_REUSE_ADDR);
       client.setSendBufferSize(CLI_SEND_BUF);
       client.setSoLinger(CLI_LINGER,CLI_LINGER_N);
       client.setSoTimeout(CLI_TIMEOUT);
       client.setTcpNoDelay(CLI_NO_DELAY);

    }
}
