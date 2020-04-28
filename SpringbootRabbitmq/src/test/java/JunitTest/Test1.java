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

}
