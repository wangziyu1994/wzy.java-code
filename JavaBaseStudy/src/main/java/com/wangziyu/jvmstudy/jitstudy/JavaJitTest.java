package com.wangziyu.jvmstudy.jitstudy;

import com.wangziyu.jvmstudy.classsfilestudy.CommonClassFile;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class JavaJitTest {


    @Test
    public  void startExplainTest(){
        LocalTime startTime=LocalTime.now();
        CommonClassFile commonClassFile=new CommonClassFile();
        LocalTime endTime=LocalTime.now();
        System.out.println("开始解释所有Class耗费"+ ChronoUnit.MILLIS.between(startTime,endTime)+"ms");
    }

    @Test
    public void runExplainTest(){
        LocalTime startTime=LocalTime.now();
        CommonClassFile commonClassFile=new CommonClassFile();
        LocalTime endTime=LocalTime.now();
        System.out.println("运行解释Class耗费"+ ChronoUnit.MILLIS.between(startTime,endTime)+"ms");
    }

    @Test
    public void mixedTest(){
        LocalTime startTime=LocalTime.now();
        CommonClassFile commonClassFile=new CommonClassFile();
        LocalTime endTime=LocalTime.now();
        System.out.println("混合解释Class耗费"+ ChronoUnit.MILLIS.between(startTime,endTime)+"ms");
    }
}
