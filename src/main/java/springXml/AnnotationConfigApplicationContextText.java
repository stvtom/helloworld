package springXml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigApplicationContextText {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main1.class);

        UserService userService =(UserService) applicationContext.getBean("userService");

        userService.sing("zhangsan");
    }
}
