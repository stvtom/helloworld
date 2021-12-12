package springXml.aop.jdkDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleAOP {

    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
                bean.getClass().getInterfaces(), advice);
    }


    public static void main(String[] args) {
        HelloService helloService  = (HelloService) Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(), new Class[]{HelloService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.err.println("代理前");
                method.invoke(new HelloServiceImpl(),args);
                System.err.println("代理后");
                return proxy;
            }
        });
        helloService.sayHelloWorld();
    }
}
