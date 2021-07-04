package com.wangziyu.testutil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientSelectorGroup {
    private static SelectorClientWorker[] mutipSelectorWorkers;
    private ClientSelectorGroup selectorGroup;
    private SocketChannel client;
    public static AtomicInteger count=new AtomicInteger(0);


    public static final String localhost = "127.0.0.1";
    public static final String remotehost = "192.168.147.129";
    public static boolean serverAcceptBlock = false;
    public static boolean readSocketBlock = false;


    public ClientSelectorGroup(int threadNum) throws IOException {
        mutipSelectorWorkers =new SelectorClientWorker[threadNum];
      for (int i=0;i<threadNum;i++){
          mutipSelectorWorkers[i]=new SelectorClientWorker(this);
          Thread worker=new Thread(mutipSelectorWorkers[i]);
          worker.start();
      }
    }



    public  void connect(int port) throws IOException {
        client= SocketChannel.open();
        client.configureBlocking(serverAcceptBlock);
        client.connect( new InetSocketAddress(localhost, port));

        client.configureBlocking(false);

        SelectorClientWorker worker=getWhichThread();
        worker.queue.add(client);
        System.out.println(Thread.currentThread().getName()+"添加channel至线程队列");
        getSelectorAndWakeUp(worker);

    }

    /**
     * 负载均衡的选出selector的线程
     * @return
     */
    public  static SelectorClientWorker getWhichThread(){
        int currentCount=count.get();
        int threadIndex=currentCount%mutipSelectorWorkers.length;
        count.incrementAndGet();
        mutipSelectorWorkers[threadIndex].setId(threadIndex);
        System.out.println("当前总数"+currentCount+"任务分配给Thread"+threadIndex+"线程处理");
        return  mutipSelectorWorkers[threadIndex];
    }


    public static Selector getSelectorAndWakeUp(SelectorClientWorker worker){
        worker.getSelector().wakeup();
        System.out.println(Thread.currentThread().getName()+"唤醒selector");
        return worker.getSelector();
    }



}
