import database.model.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springXml.transication.InvalidTransication;
import springXml.transication.IsolationTransication;
import springXml.transication.ProgrammingTransication;
import springXml.transication.ValidTransication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransicationTest {


    @Autowired
    private InvalidTransication invalidTransication;

    @Autowired
    private ValidTransication validTransication;

    @Autowired
    private IsolationTransication isolationTransication;

    @Autowired
    private ProgrammingTransication programmingTransication;

    @Test
    public void test(){
        invalidTransication.addInfo();
//        validTransication.addInfo();
    }

    @Test
    public void test1(){
        City city = isolationTransication.getCity();
    }

    @Test
    public void test2(){
//        programmingTransication.noTransication();
//        programmingTransication.programTransication1();
//        programmingTransication.programTransication2();
        programmingTransication.programTransication3();

    }



}
