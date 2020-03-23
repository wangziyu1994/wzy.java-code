package com.main;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchApplication {

	public static void main(String args[]) throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ApplicationContext context = new ClassPathXmlApplicationContext("batchReaderAndWriter.xml");
		JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("billJob");

		Map<String, JobParameter> map = new LinkedHashMap<String, JobParameter>();
		JobParameter jb = new JobParameter("11", true);
		map.put("1", jb);
		JobParameters jbs = new JobParameters(map);
		JobExecution result = launcher.run(job, jbs);
		System.out.println("结果是:" + result.toString());
	}

}
