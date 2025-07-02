package com.wang.method;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Iterator;
import java.util.Set;

public class RedisMethod {

    public static void sentinelRedisMethod(String masterName,Set<String> sentinels){
        Iterator var1=sentinels.iterator();
        while (var1.hasNext()){
        System.out.println(var1.next());
        }
        JedisSentinelPool pool=new JedisSentinelPool(masterName,sentinels);
        Jedis jedis=pool.getResource();
        String keyvalue1=jedis.get("masterkey1");
        System.out.println(keyvalue1);
    }


}
