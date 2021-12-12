package springXml.postProcess;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springXml.UserService;

public class RefreshTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("springXml");
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();

//        beanFactory.addBeanPostProcessor(new MyPostProcess());
        applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sing("哈哈哈");
        UserService userService1 = (UserService) applicationContext.getBean("userService");

        System.err.println("userService地址:"+userService);
        System.err.println("userService1地址:"+userService1);

        MyPostProcess myPostProcess =(MyPostProcess) beanFactory.getBean("myPostProcess");

    }

}
