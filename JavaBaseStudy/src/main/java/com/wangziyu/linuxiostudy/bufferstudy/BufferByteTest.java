package com.wangziyu.linuxiostudy.bufferstudy;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferByteTest {
    public static final String dirPath = "";
    public static final String fileName = "nioOutput";
    public static final String filePath = dirPath + fileName;

    @Test
    public void testBufferByte() throws IOException {
        byte[] body1 = "hello".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        System.out.println("pos:" + byteBuffer.position());
        System.out.println("limit:" + byteBuffer.limit());
        System.out.println("mark:" + byteBuffer);

        System.out.println("放入5个字节");
        byteBuffer.put(body1);
        System.out.println("mark:" + byteBuffer);

        System.out.println("放入2个字节");
        byteBuffer.put("12".getBytes());
        System.out.println("mark:" + byteBuffer);

        System.out.println("flip");
        byteBuffer.flip();
        System.out.println("mark:" + byteBuffer);

        System.out.println("get");
        System.out.println(byteBuffer.get());
        System.out.println("mark:" + byteBuffer);


        System.out.println("compact");
        byteBuffer.compact();
        System.out.println("mark:" + byteBuffer);

        System.out.println("clear");
        byteBuffer.clear();
        System.out.println("mark:" + byteBuffer);



    }


    @Test
    public void testDirectlyBufferByte() {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
    }


    public void prepare() {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }
}
