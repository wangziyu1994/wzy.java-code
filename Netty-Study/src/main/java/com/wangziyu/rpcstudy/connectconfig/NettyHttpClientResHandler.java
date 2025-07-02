package com.wangziyu.rpcstudy.connectconfig;

import com.wangziyu.rpcstudy.model.MessageBody;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;

import java.io.*;

public class NettyHttpClientResHandler extends ChannelInboundHandlerAdapter {

    private ServiceDispatcher serviceDispatcher;


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Http客户端数据处理器注册");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        FullHttpResponse httpResponse=(FullHttpResponse) msg;
        System.out.println(Thread.currentThread().getName()+"Http客户端获得数据包:"+httpResponse);
        System.out.println();
        System.out.println();
        ByteBuf byteBuf=httpResponse.content();

        //处理业务逻辑可以开启另外的线程处理,用netty当前group的线程，或者用另外group
        ctx.channel().eventLoop().submit(new Runnable() {
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
                    System.out.println(Thread.currentThread().getName()+"获取服务端响应"+messageBody);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }







            }
        });


    }
}
