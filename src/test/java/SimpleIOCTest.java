import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springXml.aop.*;
import springXml.ioc.Car;
import springXml.ioc.SimpleIOC;
import springXml.ioc.Wheel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleIOCTest.class)
public class SimpleIOCTest {


    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("applicationIocContext.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.err.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.err.println(car);
    }


    @Test
    public void getProxy() throws Exception {
        // 1. 创建一个 MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        // 3. 为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl,beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();
    }
}
