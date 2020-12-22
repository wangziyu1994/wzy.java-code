package com.wang.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("sl4")
@StepScope
public class MyStepListerner4 implements StepExecutionListener {
  public static  List<Bean1> stuList = new ArrayList<Bean1>();
    @Override
    public void beforeStep(StepExecution stepExecution) {

        System.out.println("start myitemreader2");
        Bean1 bean1 = new Bean1();
        Bean1 bean2 = new Bean1();
        Bean1 bean3 = new Bean1();
        bean1.setName("1");
        bean2.setName("2");
        bean3.setName("3");
        stuList.add(bean1);
        stuList.add(bean2);
        stuList.add(bean3);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {

        return ExitStatus.COMPLETED;
    }
}
