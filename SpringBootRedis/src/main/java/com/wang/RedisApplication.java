package com.wang;

import com.wang.config.SentinelRedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RedisApplication {



    public static void main(String[] args) {

ApplicationContext applicationContext=SpringApplication.run(RedisApplication.class,args);

        SentinelRedisConfig sentinelRedisConfig1=(SentinelRedisConfig)applicationContext.getBean("wzybean1");
        SentinelRedisConfig sentinelRedisConfig2=(SentinelRedisConfig)applicationContext.getBean("SentinelRedisConfig");
        System.out.println(sentinelRedisConfig1.getExpire("hmasterkey1"));
        System.out.println(sentinelRedisConfig2.getExpire("hmasterkey1"));


    }

    public void testredis(){
        //System.out.println(sentinelRedisConfig.getExpire("hmasterkey1"));
    }


/*    public void getRedis() {
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接redis成功！" + jedis.ping());

        //jedis.set("wangziyu","wangziyu123");

//        jedis.lpush("wzylist","1");
//        jedis.lpush("wzylist","2");
//        jedis.lpush("wzylist","3");
//        jedis.lpush("wzylist","4");
//        jedis.lpush("wzylist","5");
        Set<String> s = jedis.keys("*");
//        Iterator it=s.iterator();
//        while(it.hasNext()) {
//        	System.out.println(it.next());
//        }
        for (String a : s) {
            System.out.println(a);
        }
    }*/
}
