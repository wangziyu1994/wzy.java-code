package com.wangziyu.rpcstudy.connectconfig;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectCallBack {
    public static ConcurrentHashMap<Long, Runnable> mapping=new ConcurrentHashMap<>();
    public static void addCallBack(long requestId,Runnable completableFuture){
           mapping.putIfAbsent(requestId,completableFuture);
    }

public static void  runCallBack(long requestId){
   mapping.get(requestId).run();
   mapping.remove(requestId);
}
}
