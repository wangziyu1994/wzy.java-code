package com.wang.config;

import java.util.UUID;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wang.model.CreditBill;

@Component
@Qualifier("lm")
@StepScope
public class MyLineMapper implements LineMapper<CreditBill>{

	public CreditBill mapLine(String line, int lineNumber) throws Exception {
		CreditBill c=new CreditBill();
		String  []in=line.split(",");
		int is=in.length;
		//int l=2/0;
		for(int i=0;i<=is-1;i++) {
			
		
			c.setId(UUID.randomUUID().toString());
			c.setAccountID(in[0]);
			c.setName(in[1]);
			c.setAmount(Double.valueOf(in[2]));
			c.setDate(in[3]);
			c.setAddress(in[4]);
		}
		
		return c;
	}

}
