package com.wangziyu.rpcstudy.connectconfig;

import com.wangziyu.rpcstudy.model.MessageBody;
import com.wangziyu.rpcstudy.model.PacketMsg;
import com.wangziyu.rpcstudy.service.Order;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import sun.plugin2.message.Message;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NettyHttpServerResHandler extends ChannelInboundHandlerAdapter {

    private ServiceDispatcher serviceDispatcher;


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Http服务处理客户端数据处理器注册");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        FullHttpRequest httpRequest=(FullHttpRequest) msg;
        System.out.println(Thread.currentThread().getName()+"Http服务端获得数据包:"+httpRequest);
        System.out.println();
        System.out.println();
        ByteBuf byteBuf=httpRequest.content();

        //处理业务逻辑可以开启另外的线程处理,用netty当前group的线程，或者用另外group
        ctx.channel().eventLoop().parent().next().submit(new Runnable() {
            @Override
            public void run() {
                byte[] messageBodyBytes=new byte[byteBuf.readableBytes()];
                byteBuf.readBytes(messageBodyBytes);

                ByteArrayInputStream inputStream = new ByteArrayInputStream(messageBodyBytes);
                ObjectInputStream messageBodyObject = null;


                try {
                    messageBodyObject = new ObjectInputStream(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MessageBody messageBody= null;
                try {
                    messageBody = (MessageBody) messageBodyObject.readObject();
                    System.out.println(Thread.currentThread().getName()+"获取客户端请求"+messageBody);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream messageBodyObject2 =null ;
                ByteBuf httpResByteBuf=null;
                byte[] resbytes=new byte[1];
                try {
                    messageBody.setRes("servertoClient");
                    System.out.println(Thread.currentThread().getName()+"发送响应"+messageBody);
                    messageBodyObject2 = new ObjectOutputStream(byteArrayOutputStream);
                    messageBodyObject2.writeObject(messageBody);
                    resbytes=byteArrayOutputStream.toByteArray();
                    httpResByteBuf= ByteBufAllocator.DEFAULT.directBuffer(resbytes.length);
                    httpResByteBuf.writeBytes(resbytes);

                } catch (IOException e) {
                    e.printStackTrace();
                }

                DefaultFullHttpResponse httpResponse=new DefaultFullHttpResponse(HttpVersion.HTTP_1_0, HttpResponseStatus.OK,httpResByteBuf);
                httpResponse.headers().set(HttpHeaderNames.CONTENT_LENGTH,resbytes.length);
                System.out.println();
                System.out.println();
                ctx.writeAndFlush(httpResponse);

                System.out.println("服务端发送响应:"+httpResponse.content());


            }
        });


    }
}
