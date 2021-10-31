package com.wangziyu.linuxiostudy.fileniostudy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {
    public static final String  dirPath="";
    public static final String  fileName="nioOutput";
    public static final String  filePath=dirPath+fileName;

    public static void main(String[] args) throws IOException {
        testNio();
    }


    public static void testNio() throws IOException {
        File file=new File(filePath);
        if(file.exists()){
            file.delete();
        }
        RandomAccessFile randomAccessFile=new RandomAccessFile(filePath,"rw");
       /* byte[]  body1="hello,saber!\n".getBytes();
        byte[]  body2="hello,lancer!\n".getBytes();

        randomAccessFile.write(body1);
        randomAccessFile.write(body2);

        System.in.read();
        randomAccessFile.seek(4);

        byte[]  body3="xxx!".getBytes();
        randomAccessFile.write(body3);*/

        FileChannel fileChannel=randomAccessFile.getChannel();
        MappedByteBuffer mappedByteBuffer=fileChannel.map(FileChannel.MapMode.READ_WRITE,0,20);
        mappedByteBuffer.put("hello,saber!".getBytes());
        mappedByteBuffer.force(); //强制把pageCache刷入磁盘

    }
}
