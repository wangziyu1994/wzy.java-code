package com.wang.config;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("MyItemWriter2")
@StepScope
public class MyItemWriter2 implements ItemWriter<Bean1> {

    @Override
    public void write(List<? extends Bean1> items) throws Exception {
        System.out.println("size"+items.size());
        for(int i=0;i<=items.size()-1;i++){
            System.out.println(items.get(i));
        }
    }
}
