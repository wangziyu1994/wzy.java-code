package com.wangziyu.testutil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

public class SelectorGroup {
    private static MutipSelectorWorker[] mutipSelectorWorkers;
    private SelectorGroup selectorGroup;
    private ServerSocketChannel server;
    public static AtomicInteger count=new AtomicInteger(0);


    public static final String localhost = "127.0.0.1";
    public static final String remotehost = "192.168.147.129";
    public static boolean serverAcceptBlock = false;
    public static boolean readSocketBlock = false;


    public SelectorGroup(int threadNum) throws IOException {
        mutipSelectorWorkers =new MutipSelectorWorker[threadNum];
      for (int i=0;i<threadNum;i++){
          mutipSelectorWorkers[i]=new MutipSelectorWorker(this);
          Thread worker=new Thread(mutipSelectorWorkers[i]);
          worker.start();
      }
    }



    public  void bind(int port) throws IOException {
         server=ServerSocketChannel.open();
         server.configureBlocking(serverAcceptBlock);
         server.bind( new InetSocketAddress(localhost, port));
         MutipSelectorWorker worker=getWhichThread();
         worker.queue.add(server);
         System.out.println(Thread.currentThread().getName()+"添加channel至线程队列");
         getSelectorAndWakeUp(worker);

    }

    /**
     * 负载均衡的选出selector的线程
     * @return
     */
    public  static MutipSelectorWorker getWhichThread(){
        int currentCount=count.get();
        int threadIndex=currentCount%mutipSelectorWorkers.length;
        count.incrementAndGet();
        mutipSelectorWorkers[threadIndex].setId(threadIndex);
        System.out.println("当前总数"+currentCount+"任务分配给Thread"+threadIndex+"线程处理");
        return  mutipSelectorWorkers[threadIndex];
    }


    public static Selector getSelectorAndWakeUp(MutipSelectorWorker worker){
        worker.getSelector().wakeup();
        System.out.println(Thread.currentThread().getName()+"唤醒selector");
        return worker.getSelector();
    }



}
