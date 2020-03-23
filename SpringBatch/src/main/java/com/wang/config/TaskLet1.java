package com.wang.config;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

import javax.batch.runtime.StepExecution;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Qualifier("tl1")
@StepScope
public class TaskLet1 implements Tasklet{
	
	private static final String filePath="E:\\java-workspace\\SpringBatch\\src\\main\\resources\\input";
    @Value("#{jobParameters[fileNames]}")
	private String js;
	@Autowired
	private FilePaths fps;

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
		File files=new File(filePath);
		String []names=files.list();  
		System.out.println("获取的文件目录为"+Arrays.toString(names));
		System.out.println("获取的job参数"+js);
		 fps.setFilePath(names);
		 fps.setFileDirectory(filePath);
		return RepeatStatus.FINISHED;
		
		
		
	}

}
