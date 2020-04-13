package wang;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SendMsg {

	@Async
	public String sendMsg1(int i) {
		System.out.println("线程"+i+"发送成功");
		return "线程"+i+"发送成功";
	}
	
	@Async
	public String sendMsg2(int i) {
		System.out.println("线程"+i+"发送成功");
		return "线程"+i+"发送成功";
	}
	
	@Async
	public String sendMsg3(int i) {
		System.out.println("线程"+i+"发送成功");
		return "线程"+i+"发送成功";
	}
	
	
}
