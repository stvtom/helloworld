package springXml.postProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import springXml.UserService;

import javax.sql.rowset.serial.SerialRef;

@Component
public class MyPostProcess implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.err.println("MyPostProcess测试");
        if (beanName.equals("userService")){
            UserService userService = (UserService) bean;
//            userService.sing("前置测试");
            System.err.println("前置测试");
        }
        return bean;
    }
}
