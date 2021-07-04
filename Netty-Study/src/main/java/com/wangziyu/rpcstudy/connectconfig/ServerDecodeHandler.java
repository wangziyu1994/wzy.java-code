package com.wangziyu.rpcstudy.connectconfig;

import com.wangziyu.rpcstudy.model.MessageBody;
import com.wangziyu.rpcstudy.model.MessageHeader;
import com.wangziyu.rpcstudy.model.PacketMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerDecodeHandler extends ByteToMessageDecoder {

    public AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBufIn, List<Object> list) throws Exception {
          ByteBuf byteBuf=(ByteBuf)byteBufIn;
        System.out.println("开始调用客户端数据处理器["+byteBuf.readableBytes()+"],固定Headr长"+111);
        while(byteBuf.readableBytes()>111){
            ByteBuf serverToClient= ByteBufAllocator.DEFAULT.buffer(byteBuf.readableBytes());
            byte[] headerBytes=new byte[111];
            //不移动指针读取
            byteBuf.getBytes(byteBuf.readerIndex(),headerBytes);
            ByteArrayInputStream headBufferIn=new ByteArrayInputStream(headerBytes);
            ObjectInputStream headerInputStream=new ObjectInputStream(headBufferIn);
            MessageHeader header=(MessageHeader) headerInputStream.readObject();
            System.out.println(header);
            System.out.println("读取Header之后["+byteBuf.readableBytes()+"]");
            serverToClient.writeBytes(headerBytes);

            if(byteBuf.readableBytes()>=header.getDatalen()){
                byte[] bodyBytes=new byte[(int)header.getDatalen()];
                //指针偏移一个报文头的长度
                byteBuf.readBytes(111);
                byteBuf.readBytes(bodyBytes);
                ByteArrayInputStream bodyBufferIn=new ByteArrayInputStream(bodyBytes);
                ObjectInputStream bodyInputStream=new ObjectInputStream(bodyBufferIn);
                MessageBody body=(MessageBody) bodyInputStream.readObject();
                System.out.println(body);
                System.out.println("读取Body之后["+byteBuf.readableBytes()+"]");
                serverToClient.writeBytes(bodyBytes);
                PacketMsg packetMsg=new PacketMsg();
                packetMsg.setMessageHeader(header);
                packetMsg.setMessageBody(body);
                list.add(packetMsg);
                System.out.println("解码添加"+header.getRequestID()+"成功");
                channelHandlerContext.channel().writeAndFlush(serverToClient);
                atomicInteger.incrementAndGet();
                System.out.println("发送报文条数["+atomicInteger.get()+"]");
            }else{
                serverToClient.resetReaderIndex();
                System.out.println("报文体长度不足，下次处理");
                break;
            }



        }
        System.out.println("服务端数据处理完成");




    }
}
