package com.wang.config;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wang.model.CreditBill;


@Component
@Qualifier("la")
@StepScope
public class Aggervator implements LineAggregator<CreditBill>{

	public String aggregate(CreditBill item) {
		System.out.println(item.getAddress());
		return null;
	}

}
