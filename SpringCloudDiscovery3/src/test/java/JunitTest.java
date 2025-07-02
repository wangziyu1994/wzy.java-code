import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

public class JunitTest {

    @Test
    public void test1(){

            String pwd = "jW/EOIkMDpyxfkVNcBfRrzW5ICdxOEX8qYbIPEZ2iA6vTFxssAdOuS9uOrcIEcfDU408o6OddWPK3LUKk4plHw==";
            String pub = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJO42W6KNouAPY/8RnFpAufKur5O4kec9m8qeQjtzpRAa+Wic7ISN8gFPf1bajfmLvR4/WolpN5F0o/Be+xu1LsCAwEAAQ==";
            try {
                String depwd = ConfigTools.decrypt(pub, pwd);
                System.out.println(depwd);
            } catch (Exception e) {
                e.printStackTrace();
            }


    }

}
