package com.wang.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sl2")
@StepScope
public class MyStepListener2 implements StepExecutionListener{

	public void beforeStep(StepExecution stepExecution) {
		System.out.println("step2开始了");
		
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("step2完成了");
		return null;
	}

}
