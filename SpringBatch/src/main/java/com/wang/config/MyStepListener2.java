package com.wang.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sl2")
@StepScope
public class MyStepListener2 implements StepExecutionListener{

	@Value("#{stepExecutionContext['fileNames']}")
	public String fileName;

	public static String fileName1;

	public void beforeStep(StepExecution stepExecution) {
		System.out.println("step2开始了");
		stepExecution.getJobExecution().getExecutionContext().putString("fileNames","stepUpdate");
		String jobparam=stepExecution.getJobExecution().getExecutionContext().getString("fileNames");
		//this.fileName=jobparam;
		fileName1=jobparam;
		System.out.println("赋值成功后:"+fileName);
		System.out.println("赋值成功后:"+this.fileName);
	}

	public ExitStatus afterStep(StepExecution stepExecution) {

		String jobparam1=stepExecution.getJobExecution().getJobParameters().getString("fileNames");
		System.out.println("jobParameter是："+jobparam1);
		System.out.println("job执行参数"+this.fileName);
		System.out.println("step2完成了");
		return ExitStatus.COMPLETED;
	}

}
