package springXml.register;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springXml.UserService;

public class DefinitionScannerTest {

    public static void main(String[] args) {
        DefinitionScannerContext applicationContext = new DefinitionScannerContext("springXml");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName:beanDefinitionNames){
            System.err.println(beanName);
        }
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.sing("张三");
    }
}
