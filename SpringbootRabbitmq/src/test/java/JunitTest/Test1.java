package JunitTest;


import com.wangziyu.StartBootApp;
import com.wangziyu.service.Consumer;
import com.wangziyu.service.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartBootApp.class)
public class Test1 {

    @Autowired
    private Producer producer;


@Test
    public void send() throws InterruptedException {
    for(int i=1;i<=100;i++){
        Thread.sleep(1000);
        producer.sendMsg();
        System.out.println("已发送第"+i+"条消息");
    }
}

    @Test
    public void send1() throws InterruptedException {
        producer.sendMsg1();
        producer.sendMsg2();
    }


    @Test
    public void send2() throws InterruptedException {
        producer.sendMsg3();
        producer.sendMsg4();
        producer.sendMsg5();
    }

    @Test
    public void send3() throws InterruptedException {
        producer.sendMsg6();
    }

}
