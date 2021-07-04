package com.wangziyu.rpcstudy.connectconfig;

import com.wangziyu.rpcstudy.model.MessageBody;
import com.wangziyu.rpcstudy.model.MessageHeader;
import com.wangziyu.rpcstudy.model.PacketMsg;
import com.wangziyu.rpcstudy.service.Order;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReadFromClientHandler extends ChannelInboundHandlerAdapter {

    private ServiceDispatcher serviceDispatcher;

    public ReadFromClientHandler(ServiceDispatcher serviceDispatcher) {
        this.serviceDispatcher = serviceDispatcher;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("服务处理客户端数据处理器注册");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        PacketMsg packetMsg=(PacketMsg) msg;
        System.out.println(Thread.currentThread().getName()+"服务端获得数据包:"+packetMsg);

        //处理业务逻辑可以开启另外的线程处理,用netty当前group的线程，或者用另外group
        ctx.channel().eventLoop().parent().next().submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始处理业务流程");
                Order orderService=(Order)serviceDispatcher.serviceMap.get("订单服务");
                Class<?> clazz=orderService.getClass();
                try {
                    Method method=clazz.getMethod("doOrder");
                    method.invoke(orderService);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });

       /* ByteBuf byteBuf=(ByteBuf)msg;
        System.out.println("开始调用客户端数据处理器["+byteBuf.readableBytes()+"],固定Headr长"+111);
        while(byteBuf.readableBytes()>111){
            ByteBuf serverToClient= ByteBufAllocator.DEFAULT.buffer(byteBuf.readableBytes());
            byte[] headerBytes=new byte[111];
            byteBuf.readBytes(headerBytes);
            ByteArrayInputStream headBufferIn=new ByteArrayInputStream(headerBytes);
            ObjectInputStream headerInputStream=new ObjectInputStream(headBufferIn);
            MessageHeader header=(MessageHeader) headerInputStream.readObject();
            System.out.println(header);
            System.out.println("读取Header之后["+byteBuf.readableBytes()+"]");
            serverToClient.writeBytes(headerBytes);

            if(byteBuf.readableBytes()>=header.getDatalen()){
                byte[] bodyBytes=new byte[(int)header.getDatalen()];
                byteBuf.readBytes(bodyBytes);
                ByteArrayInputStream bodyBufferIn=new ByteArrayInputStream(bodyBytes);
                ObjectInputStream bodyInputStream=new ObjectInputStream(bodyBufferIn);
                MessageBody body=(MessageBody) bodyInputStream.readObject();
                System.out.println(body);
                System.out.println("读取Body之后["+byteBuf.readableBytes()+"]");
                serverToClient.writeBytes(bodyBytes);
                System.out.println("发送"+header.getRequestID()+"成功");
            }

           ctx.channel().writeAndFlush(serverToClient);

        }
        System.out.println("服务端数据处理完成");*/
    }
}
