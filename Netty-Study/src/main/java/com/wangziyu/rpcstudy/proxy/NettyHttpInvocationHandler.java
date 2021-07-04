package com.wangziyu.rpcstudy.proxy;

import com.wangziyu.rpcstudy.connectconfig.NettyHttpClientResHandler;
import com.wangziyu.rpcstudy.model.MessageBody;
import com.wangziyu.rpcstudy.model.MessageHeader;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.UUID;

public class NettyHttpInvocationHandler<T> implements InvocationHandler {
    private Class<T> target;
    private InetSocketAddress address;

    public NettyHttpInvocationHandler(Class<T> target, InetSocketAddress address) {
        this.target = target;
        this.address = address;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //获取远程服务的方法名称
        String methodName = method.getName();
        //获取远程服务的服务名称
        String remoteservice = target.getName();
        //获取参数类型
        Class<?>[] parameterType = method.getParameterTypes();
        //组装请求体对象
        MessageBody messageBody = getReqBody(remoteservice, methodName, parameterType, args);


        //将报文头对象写入缓冲区
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream messageObjectOutPut = new ObjectOutputStream(outputStream);
        messageObjectOutPut.writeObject(messageBody);
        byte[] bodyBytes = outputStream.toByteArray();
        ByteBuf httpBodyBuf= ByteBufAllocator.DEFAULT.buffer(bodyBytes.length);
        httpBodyBuf.writeBytes(bodyBytes);
        DefaultFullHttpRequest httpRequest=new DefaultFullHttpRequest(HttpVersion.HTTP_1_0,HttpMethod.POST,"/",httpBodyBuf);
        httpRequest.headers().set(HttpHeaderNames.CONTENT_LENGTH,bodyBytes.length);


        System.out.println("netty客户端发送http请求");
        NioEventLoopGroup nioEventLoopGroup=new NioEventLoopGroup(1);
        Bootstrap bootStrap=new Bootstrap();
        bootStrap.group(nioEventLoopGroup);
        bootStrap.channel(NioSocketChannel.class);
        bootStrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel channel) throws Exception {
                ChannelPipeline channelPipeline=channel.pipeline();
                channelPipeline.addLast(new HttpClientCodec());
                channelPipeline.addLast(new HttpObjectAggregator(1024*512));
                channelPipeline.addLast(new NettyHttpClientResHandler());
            }
        });

        ChannelFuture channelFuture=bootStrap.connect(address);
        channelFuture= channelFuture.sync();
        Channel socketChannel=channelFuture.channel();
        socketChannel.writeAndFlush(httpRequest).sync();
        System.out.println("netty客户端发送http请求成功");



        return null;
    }




    public MessageBody getReqBody(String service, String method, Class<?>[] paramType, Object[] args) {
        MessageBody messageBody = new MessageBody();
        messageBody.setName(service);
        messageBody.setMethodname(method);
        messageBody.setParameterTypes(paramType);
        messageBody.setArgs(args);
       // System.out.println("组装报文头成功");
        return messageBody;
    }


    public MessageHeader getReqHeader(byte[] headBytes) {
        MessageHeader messageHeader = new MessageHeader();
        int flag=0x14141414;
        long requestId= UUID.randomUUID().getLeastSignificantBits();
        requestId=Math.abs(requestId);
        messageHeader.setFlag(flag);
        messageHeader.setDatalen(headBytes.length);
        messageHeader.setRequestID(requestId);
        //System.out.println("组装报文体成功");
        return  messageHeader;
    }
}
