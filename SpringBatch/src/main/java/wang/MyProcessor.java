package wang;

import com.mapper.MyMapper;
import com.model.CreditBill;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("pp")
@StepScope
public class MyProcessor implements ItemProcessor<CreditBill,CreditBill>{

	@Autowired
	private MyMapper mma;

	
	public CreditBill process(CreditBill cc) throws Exception {
		
		
		/*
		 * String rec1=sm.sendMsg1(1); String rec2=sm.sendMsg1(2); String
		 * rec3=sm.sendMsg1(3);
		 * 
		 * System.out.println(rec1); System.out.println(rec2); System.out.println(rec3);
		 */
		
		mma.insertC(cc);
		System.out.println("入库成功！");
		return cc;
	}

	

	

}
