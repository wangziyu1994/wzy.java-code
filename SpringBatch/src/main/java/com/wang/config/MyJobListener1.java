package com.wang.config;

import java.io.File;
import java.util.Date;

import javax.batch.api.listener.JobListener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("jl")
public class MyJobListener1 implements JobExecutionListener{
	
    
	public void beforeJob(JobExecution jobExecution) {
		
        System.out.println("开始JOB");

		/*jobExecution.getExecutionContext().putString("fileNames","stepUpdate");
		String jobparam=jobExecution.getExecutionContext().getString("fileNames");

		System.out.println("赋值成功后:"+jobparam);*/
		
		
	}

	public void afterJob(JobExecution jobExecution) {
		System.out.println("完成JOB");
		
	}



}
