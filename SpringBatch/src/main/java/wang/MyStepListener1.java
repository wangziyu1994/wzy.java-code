package wang;

import javax.batch.api.listener.StepListener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sl1")
@StepScope

public class MyStepListener1 implements StepExecutionListener{
	
	@Autowired
	private FilePaths fps;


	public void beforeStep(StepExecution stepExecution) {
		System.out.println("开始Step1");
		
	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		
		 if(fps.getFilePath()!=null&&fps.getFilePath().length!=0) 
		 { 
		 System.out.println("完成Step1"); 
		 return new  ExitStatus("success"); 
		} 
		 else { 
		 System.out.println("完成Step1-未发现文件"); 
		 return   new ExitStatus("fail");
		 }
		 
		
	}

}
