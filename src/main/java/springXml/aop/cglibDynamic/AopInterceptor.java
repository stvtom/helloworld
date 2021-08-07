package springXml.aop.cglibDynamic;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class AopInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        System.out.println("before method execute");

        Object obj = arg3.invokeSuper(arg0, arg2);

        System.out.println("after method execute");

        return obj;
    }
}
