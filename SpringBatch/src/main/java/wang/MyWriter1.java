package wang;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;


import com.model.CreditBill;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mw")
@StepScope
public class MyWriter1 implements ItemWriter<CreditBill>{
	
	@Autowired
	private SendMsg sm;
	
	@Autowired
	private FilePaths fps;

	public void write(List<? extends CreditBill> items) throws Exception {
		
		/*
		 * sm.sendMsg1(0); sm.sendMsg1(1); sm.sendMsg1(2); sm.sendMsg1(3);
		 * sm.sendMsg1(4); sm.sendMsg1(5); sm.sendMsg1(6); sm.sendMsg1(7);
		 * sm.sendMsg1(8); sm.sendMsg1(9);
		 */
			
		File f=new File(fps.getCurrentFile());
		if(!f.exists()) {
			f.createNewFile();
		}
		
		Writer writer = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(f,true), "UTF-8"));
		
		for(int i=0;i<=items.size()-1;i++) {
			System.out.println("当前读取第"+items.get(i).getAccountID()+"条记录");
			if(items.get(i).getAccountID().equals("15")) {
				try {
					int l = 2 / 0;
				}
				catch(Exception e){
					System.out.println("捕捉异常！");
				}
			}
			writer.write(items.get(i).getAccountID()+",");
			writer.write(items.get(i).getName()+",");
			writer.write(items.get(i).getAmount()+",");
			writer.write(items.get(i).getDate()+",");
			writer.write(items.get(i).getAddress()+"");
			writer.write("\t\n");
		}
		writer.flush();
		writer.close();
	
	}






}
