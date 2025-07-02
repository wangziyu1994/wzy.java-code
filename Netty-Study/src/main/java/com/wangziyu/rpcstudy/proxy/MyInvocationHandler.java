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

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyInvocationHandler<T> implements InvocationHandler {
    private Class<T> target;
    private InetSocketAddress address;

    public MyInvocationHandler(Class<T> target, InetSocketAddress address) {
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

        outputStream.reset();
        MessageHeader messageHeader =getReqHeader(bodyBytes);
        ObjectOutputStream headerObjectOutPut = new ObjectOutputStream(outputStream);
        headerObjectOutPut.writeObject(messageHeader);
        byte[] headerBytes = outputStream.toByteArray();
        System.out.println("报文头组装完成");


        //如果同一进程存在此服务，那么不走网络Socket直接本地调用方法
        if(ServiceDispatcher.existService(remoteservice)){
         System.out.println("本地存在"+remoteservice+",直接走本地调用");
         Class<?> clazz=ServiceDispatcher.getService(remoteservice).getClass();

           Order localOrder= (Order)ServiceDispatcher.getService(remoteservice);
           localOrder.doOrder();
        }else {


            ClientConnFactory clientConnFactory = ClientConnFactory.getClientFactory();
            NioSocketChannel clientSocket = clientConnFactory.getClientSocket(address);


            //注册连接成功回调机制，并且解除主线程的阻塞
            CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
            ConnectCallBack.addCallBack(messageHeader.getRequestID(), new Runnable() {

                @Override
                public void run() {
                    try {
                        cyclicBarrier.await();
                        System.out.println("触发回调，主线程解除阻塞");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });

            ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(bodyBytes.length + headerBytes.length);
            long requestId = messageHeader.getRequestID();
            byteBuf.writeBytes(headerBytes);
            byteBuf.writeBytes(bodyBytes);

            ChannelFuture sendFuture = clientSocket.writeAndFlush(byteBuf);
            System.out.println("主线程阻塞.....");
            cyclicBarrier.await();
            System.out.println("主线程解除阻塞.....");
        }

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
