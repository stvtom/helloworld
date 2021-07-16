package springXml;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class ApplicationContextText {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext
                = new SpringApplication(Main1.class).run();

        ConfigurableEnvironment environment =
                applicationContext.getEnvironment();
        System.err.println(environment.getPropertySources());

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//
//        for (String name :beanDefinitionNames){
//            System.err.println(name);
//        }


        ConfigurableListableBeanFactory beanFactory =
                applicationContext.getBeanFactory();

        beanFactory.getBeanDefinition("userService");

        UserService userService1 = (UserService)  beanFactory.getBean("userService");

        System.err.println(userService1.sing("11"));
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.sing("张三");

        PersonService personService = (PersonService) beanFactory.getBean("personService");

        personService.dance("Lisi");

    }
}
