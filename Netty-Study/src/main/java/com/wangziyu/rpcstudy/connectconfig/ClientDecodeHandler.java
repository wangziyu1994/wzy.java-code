package com.wangziyu.rpcstudy.connectconfig;

import com.wangziyu.rpcstudy.model.MessageBody;
import com.wangziyu.rpcstudy.model.MessageHeader;
import com.wangziyu.rpcstudy.model.PacketMsg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientDecodeHandler extends ByteToMessageDecoder {
    private AtomicInteger atomicInteger=new AtomicInteger(0);
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBufIn, List<Object> list) throws Exception {
        ByteBuf byteBuf=(ByteBuf)byteBufIn;
        System.out.println("开始调用服务端数据处理器["+byteBuf.readableBytes()+"],固定Headr长"+111);
        while(byteBuf.readableBytes()>111){
            byte[] headerBytes=new byte[111];
            byteBuf.getBytes(byteBuf.readerIndex(),headerBytes);
            ByteArrayInputStream headBufferIn=new ByteArrayInputStream(headerBytes);
            ObjectInputStream headerInputStream=new ObjectInputStream(headBufferIn);
            MessageHeader header=(MessageHeader) headerInputStream.readObject();
            System.out.println(header);
            System.out.println("读取Header之后["+byteBuf.readableBytes()+"]");



            if(byteBuf.readableBytes()>=header.getDatalen()){
                byte[] bodyBytes=new byte[(int)header.getDatalen()];
                byteBuf.readBytes(111);
                byteBuf.readBytes(bodyBytes);
                ByteArrayInputStream bodyBufferIn=new ByteArrayInputStream(bodyBytes);
                ObjectInputStream bodyInputStream=new ObjectInputStream(bodyBufferIn);
                MessageBody body=(MessageBody) bodyInputStream.readObject();
                System.out.println(body);
                System.out.println("读取Body之后["+byteBuf.readableBytes()+"]");
                System.out.println("接收"+header.getRequestID()+"成功");
                System.out.println("开始调用回调");
                ConnectCallBack.runCallBack(header.getRequestID());
                atomicInteger.incrementAndGet();
                System.out.println("接收报文条数["+atomicInteger.get()+"]");
                PacketMsg packetMsg=new PacketMsg();
                packetMsg.setMessageHeader(header);
                packetMsg.setMessageBody(body);
                list.add(packetMsg);
                System.out.println("解码添加"+header.getRequestID()+"成功");
            }else{
                System.out.println("报文体长度不足，下次读取");
                break;
            }


        }
        System.out.println("服务端数据处理完成");
    }
}
