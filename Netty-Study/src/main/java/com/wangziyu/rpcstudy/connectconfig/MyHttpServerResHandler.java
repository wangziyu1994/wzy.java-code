package com.wangziyu.rpcstudy.connectconfig;

import com.wangziyu.rpcstudy.model.MessageBody;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpResponse;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyHttpServerResHandler extends HttpServlet {




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream servletInputStream=req.getInputStream();
        ObjectInputStream objectInputStream=new ObjectInputStream(servletInputStream);
        MessageBody messageBody= null;
        try {
            messageBody = (MessageBody)objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("服务端接收请求"+messageBody);

        messageBody.setRes("serverToClient");

        ServletOutputStream servletOutputStream=resp.getOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(servletOutputStream);
        objectOutputStream.writeObject(messageBody);
        System.out.println("服务端发送响应"+messageBody);
    }
}
