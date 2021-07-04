package com.wangziyu.rpcstudy.proxy;

import com.wangziyu.rpcstudy.connectconfig.ClientConnFactory;
import com.wangziyu.rpcstudy.connectconfig.ConnectCallBack;
import com.wangziyu.rpcstudy.connectconfig.ServiceDispatcher;
import com.wangziyu.rpcstudy.model.MessageBody;
import com.wangziyu.rpcstudy.model.MessageHeader;
import com.wangziyu.rpcstudy.service.Order;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.util.concurrent.CompleteFuture;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;

public class MyHttpInvocationHandler<T> implements InvocationHandler {
    private Class<T> target;
    private InetSocketAddress address;

    public MyHttpInvocationHandler(Class<T> target, InetSocketAddress address) {
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
        System.out.println("报文体组装完成");


      /*  MessageHeader messageHeader =getReqHeader(bodyBytes);
        ObjectOutputStream headerObjectOutPut = new ObjectOutputStream(outputStream);
        headerObjectOutPut.writeObject(messageHeader);
        byte[] headerBytes = outputStream.toByteArray();
        System.out.println("报文头组装完成");*/



        HttpURLConnection  httpConnect=getHttpReqHeader("http://localhost:1200");
        OutputStream httpOutputStream = httpConnect.getOutputStream();
        ObjectOutputStream httpObjectOutPutStream = new ObjectOutputStream(httpOutputStream);
        httpObjectOutPutStream.writeObject(messageBody);
        System.out.println("Http报文头发送.....");


        boolean flag=true;

        while(flag) {
            System.out.println("服务端响应码"+httpConnect.getResponseCode());
            MessageBody httpResBody = null;
            Thread.sleep(1000);
            if (200==httpConnect.getResponseCode()) {
                InputStream inputStream = httpConnect.getInputStream();
                ObjectInputStream httpObjectInputStream = new ObjectInputStream(inputStream);
                httpResBody = (MessageBody) httpObjectInputStream.readObject();
                System.out.println("http服务端返回" + httpResBody);
                flag=false;
            }else{
                System.out.println("http端重新尝试获取响应");
            }

        }



        return null;
    }

    private HttpURLConnection getHttpReqHeader(String httpUrl)  {
        URL httpUrlObject=null;
        HttpURLConnection httpURLConnection=null;
        try {
            httpUrlObject=new URL(httpUrl);
            httpURLConnection=(HttpURLConnection) httpUrlObject.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpURLConnection;


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
