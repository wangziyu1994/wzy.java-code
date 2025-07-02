package com.wangziyu.nettysimple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.junit.Test;

public class NettySimpleTest {


    @Test
    public void testNettyByteBuffer(){

        ByteBuf byteBuffer= ByteBufAllocator.DEFAULT.buffer(8,20);
        byte[] messageByte1="abcdefg".getBytes();
        byteBuffer.writeBytes(messageByte1);
        testReadByteBufferInfo(byteBuffer);

        byte[] messageByte2="abcdefg".getBytes();
        byteBuffer.writeBytes(messageByte2);
        testWriteByteBufferInfo(byteBuffer);

    }


    public void testReadByteBufferInfo(ByteBuf byteBuf) {
        System.out.println("isReadAble " + byteBuf.isReadable());
        System.out.println("beforeReadIndex " + byteBuf.readerIndex());
        System.out.println("readable Bytes " + byteBuf.readableBytes());
        System.out.println("afterReadIndex" + byteBuf.readerIndex());
        testCapacity(byteBuf);

    }


    public void testWriteByteBufferInfo(ByteBuf byteBuf) {
        System.out.println("isWriteable " + byteBuf.isWritable());
        System.out.println("beforeWriteIndex " + byteBuf.readerIndex());
        System.out.println("writeable Bytes " + byteBuf.writableBytes());
        System.out.println("afterWriteIndex" + byteBuf.readerIndex());
        testCapacity(byteBuf);
    }


    public void testCapacity(ByteBuf byteBuf) {
        System.out.println("current capacity  " + byteBuf.capacity());
        System.out.println("max capacity " + byteBuf.maxCapacity());
    }


    public void testReadByteBuffdderInfo(ByteBuf byteBuf) {
        System.out.println("isReadAble " + byteBuf.isReadable());
        System.out.println("beforeReadIndex " + byteBuf.readerIndex());
        System.out.println("read Bytes " + byteBuf.readableBytes());
        System.out.println("afterReadIndex" + byteBuf.readerIndex());

    }
}
