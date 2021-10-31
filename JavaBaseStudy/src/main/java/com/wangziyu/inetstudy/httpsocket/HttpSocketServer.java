package com.wangziyu.inetstudy.httpsocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class HttpSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(2200);
        System.out.println("server 2200  start!");
        while(true){
            Socket socket=serverSocket.accept();
            System.out.println("accept a socket");
            DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(dataInputStream));
            StringBuilder stringBuilder=new StringBuilder();
            String line="";
            while(!(line=bufferedReader.readLine()).isEmpty()){
              stringBuilder.append(line);

            }

            String requestStr=stringBuilder.toString();
            System.out.println(requestStr);
            System.out.println("===========================================");
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("HTTP/1.1 200 ok\n\nHello,saber!\n");
            bufferedWriter.flush();
            bufferedWriter.close();
            socket.close();

        }
    }
}
