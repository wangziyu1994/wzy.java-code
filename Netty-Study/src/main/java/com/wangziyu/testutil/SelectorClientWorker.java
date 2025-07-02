package com.wangziyu.testutil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class SelectorClientWorker implements Runnable{

    private Selector selector;
    private ClientSelectorGroup selectorGroup;

    public static final String localhost = "127.0.0.1";
    public static final String remotehost = "192.168.147.129";
    public static boolean serverAcceptBlock = false;
    public static boolean readSocketBlock = false;
    public static int selectCount = 0;

    private int id;

    public  LinkedBlockingDeque<Channel> queue=new LinkedBlockingDeque<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SelectorClientWorker(ClientSelectorGroup selectorGroup) throws IOException {
        this.selectorGroup = selectorGroup;
        this.selector=Selector.open();
    }

    public SelectorClientWorker(Selector selector) {
        this.selector = selector;
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        int count=0;
        System.out.println(Thread.currentThread().getName()+" 开始工作");
       while(true){
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           if(!queue.isEmpty()){
               System.out.println(Thread.currentThread().getName()+"当前工作队列存在任务开始处理");
               try {
                   Channel channel=queue.take();
                   if(count==0) {
                       registerWriteChannelToSelector(channel);
                       count++;
                   }

               } catch (InterruptedException | IOException e) {
                   e.printStackTrace();
               }
           }


           int conNum=0;
           Set<SelectionKey> connFds = new HashSet<>();
           try {
               conNum = selector.select();
               System.out.println(Thread.currentThread().getName()+"  select 事件数  "+conNum);
           } catch (IOException e) {
               e.printStackTrace();
           }

           if(conNum>0) {
               connFds = selector.selectedKeys();
               Iterator<SelectionKey> iterator = connFds.iterator();
               while (iterator.hasNext()) {
                   System.out.println(Thread.currentThread().getName()+"  发现服务端发生IO事件的连接");
                   SelectionKey currentConnFd = iterator.next();
                   iterator.remove();
                   //判断文件描述符是否可以被接收
                   if (currentConnFd.isAcceptable()) {
                       System.out.println(Thread.currentThread().getName()+"  accept连接");
                       //接收客户短连接文件描述符
                       try {
                           acceptNewClientSocket(currentConnFd);
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
                   //接收完之后处理 客户端连接的数据
                   else if (currentConnFd.isReadable()) {
                       System.out.println(Thread.currentThread().getName()+"  处理可以读的连接...");
                       try {
                           processData(currentConnFd);
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   } else {
                       System.out.println("用户进程处理可以写的连接");
                       try {
                           responseToClient(currentConnFd);
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }

            System.out.println(Thread.currentThread().getName()+"  准备开始下一次select。。。。。。。。。。");
           /* try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

        }

    }


    /**
     * 服务器bind监听端口，注册selector accept事件
     * @param channel
     * @throws ClosedChannelException
     */
    public  void registerReadChannelToSelector(Channel channel) throws IOException {
            SocketChannel client=(SocketChannel)channel;
            client.configureBlocking(false);
            ByteBuffer byteBuffer=ByteBuffer.allocateDirect(50);
            client.register(selector,SelectionKey.OP_READ,byteBuffer);
            queue.add(client);
            System.out.println("客户端连接: "+client.getRemoteAddress()+"注册读事件成功");
    }



    public  void registerWriteChannelToSelector(Channel channel) throws IOException {
        SocketChannel client=(SocketChannel)channel;
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(50);
        byte[] bytes="客户端访问服务端".getBytes();
        byteBuffer.put(bytes);
        client.register(selector,SelectionKey.OP_WRITE,byteBuffer);
        System.out.println("客户端连接: "+client.getRemoteAddress()+"注册写事件成功");

        registerReadChannelToSelector(channel);


    }


    public  void acceptNewClientSocket(SelectionKey currentSelectionKey) throws IOException {
        ServerSocketChannel server=(ServerSocketChannel) currentSelectionKey.channel();
        SocketChannel socketChannel=server.accept();
        SelectorClientWorker worker=ClientSelectorGroup.getWhichThread();
        worker.queue.add(socketChannel);
        worker.selector.wakeup();
        System.out.println("唤醒Thread"+worker.getId()+"的selector处理读事件");
    }



    public  void processData(SelectionKey currentSelectionKey) throws IOException {
            SocketChannel clientSocket=(SocketChannel) currentSelectionKey.channel();
            ByteBuffer byteBuffer=(ByteBuffer)currentSelectionKey.attachment();
            int dataLength=0;
            try {
                dataLength=clientSocket.read(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(dataLength>0){
                byte[] data=new byte[dataLength];
                byteBuffer.position(0);
                byteBuffer.get(data,0,dataLength-1);
                String res=new String(data);
                System.out.println("data:"+res);
            }else if(dataLength==0){

            }
            else{
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }




    public  void responseToClient(SelectionKey currentSelectionKey) throws IOException {
        Thread writeThread=new Thread(()-> {
            SocketChannel clientSocket = (SocketChannel) currentSelectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
            try {
                byte[] bytes = ("server response to cleint" + clientSocket.getRemoteAddress()).getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byteBuffer.put(byteBuffer);
            try {
                clientSocket.write(byteBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byteBuffer.clear();
        });

        System.out.println("启动写线程"+ writeThread.getName());
        writeThread.start();

    }
}
