package com.wang.processor;

import org.springframework.batch.item.ItemProcessor;

import com.wang.model.CreditBill;

public class CreditBillProcessor implements ItemProcessor<CreditBill,CreditBill>{

	public CreditBill process(CreditBill item) throws Exception {
		System.out.println("执行process方法"+item.toString());
		return item;
	}

}
