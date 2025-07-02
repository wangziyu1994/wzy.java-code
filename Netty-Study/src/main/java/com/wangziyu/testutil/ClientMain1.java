package com.wangziyu.testutil;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ClientMain1 {
    //client properties
    public static final int serverPort = 1200;
    public static final String localServerIp = "localhost";
    public static final String remoteServerIp = "192.168.147.129";

    public static final int SEND_BUFFER_SIZE = 20;
    public static boolean CLI_NO_DELAY = false;

    public static void main(String[] args) throws IOException {
        ClientStart();
    }


    public static void ClientStart() throws IOException {
        Socket client = new Socket(localServerIp, serverPort);
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
                System.out.println("sdfdsfdf");
                InputStream serverIn=client.getInputStream();
                InputStreamReader serverInReader=new InputStreamReader(serverIn);
                BufferedReader serverReader=new BufferedReader(serverInReader);
                String serverMsg=serverReader.readLine();

                if(serverMsg!=null){
                    byte[] bbc = serverMsg.getBytes();
                    System.out.println(new String(bbc));
                }
            }





            System.out.println("finish");
        }


    }

    public static void clientInit(Socket client) throws SocketException {
        client.setTcpNoDelay(CLI_NO_DELAY);
        client.setSendBufferSize(SEND_BUFFER_SIZE);
    }
}
