package com.wang.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@ComponentScan(value="com.wang")
public class SpringThreadConfig implements AsyncConfigurer{

	

	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor task=new ThreadPoolTaskExecutor();
		task.setCorePoolSize(5);
		task.setMaxPoolSize(10);
		task.setQueueCapacity(25);
		task.initialize();
		return task;
	}

	

}
