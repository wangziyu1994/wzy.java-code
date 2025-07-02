package com.wang.config;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Qualifier("MyItemReader2")
@StepScope
public class MyItemReader2 implements ItemReader<Bean1> {

    private int count = 0;

    @Override
    public Bean1 read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        System.out.println("第" + (count++) + "次执行MyItemReader-read方法");
        if (count == MyStepListerner4.stuList.size()) {
            return null;
        } else {

            return MyStepListerner4.stuList.get(count);

        }
    }
}
