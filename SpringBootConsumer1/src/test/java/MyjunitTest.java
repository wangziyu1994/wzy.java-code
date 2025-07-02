import com.UserApplication;
import com.controller.UserController;
import com.wangziyu.Interfaces.ProviderInterface1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= UserApplication.class)
public class MyjunitTest {

    @Autowired
private UserController userController;
    @Autowired
    private ProviderInterface1 providerInterface1;

    @Test
    public void test(){
        SpringApplication.run(UserApplication.class);
        providerInterface1.providerInterface1();


    }






}
