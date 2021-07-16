package springXml.postProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import springXml.Main1;

@Service
public class SpringRefreshText {


    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = new SpringApplication(Main1.class).run();

        applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());

    }

}
