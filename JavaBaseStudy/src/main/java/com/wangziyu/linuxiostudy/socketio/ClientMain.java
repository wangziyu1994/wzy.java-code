package com.wangziyu.linuxiostudy.socketio;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ClientMain {
    //client properties
    public static final int serverPort = 1200;
    public static final String localServerIp = "localhost";
    public static final String remoteServerIp = "192.168.147.129";

    public static final int SEND_BUFFER_SIZE = 20;
    public static boolean CLI_NO_DELAY = false;

    public static boolean KEEP_ALIVE=true;

    public static void main(String[] args) throws IOException {
        ClientStart();
    }


    public static void ClientStart() throws IOException {
        Socket client = new Socket(remoteServerIp, serverPort);
        clientInit(client);
        OutputStream outputStream = client.getOutputStream();
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        while (true) {
            String line = reader.readLine();
            if (line != null) {
                byte[] bb = line.getBytes();
                for (byte b : bb) {
                    outputStream.write(b);
                }
            }
            System.out.println("finish");
        }


    }

    public static void clientInit(Socket client) throws SocketException {
        client.setTcpNoDelay(CLI_NO_DELAY);
        client.setSendBufferSize(SEND_BUFFER_SIZE);
        client.setKeepAlive(KEEP_ALIVE);
    }
}
