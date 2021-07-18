import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springXml.transication.InvalidTransication;
import springXml.transication.ValidTransication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransicationTest {


    @Autowired
    private InvalidTransication invalidTransication;

    @Autowired
    private ValidTransication validTransication;

    @Test
    public void test(){
        invalidTransication.addInfo();
//        validTransication.addInfo();
    }

}
