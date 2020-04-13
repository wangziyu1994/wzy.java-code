package com;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.model.CreditBill;
@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchApplication {

	
	public static void main(String args[]) throws BeansException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
	ConfigurableApplicationContext ctx=SpringApplication.run(SpringBatchApplication.class,args);
	CreditBill c=ctx.getBean(CreditBill.class);	
	System.out.println("路径是:"+CreditBill.path);
	 JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);	
	 JobParameters jobParameters = new JobParametersBuilder()
            .addDate("date", new Date()) 
             .addString("fileNames", "jobparams1")
             .toJobParameters();
     jobLauncher.run(ctx.getBean("myjob1", Job.class), jobParameters);
	}
}
