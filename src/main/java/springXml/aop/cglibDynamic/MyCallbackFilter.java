package springXml.aop.cglibDynamic;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class MyCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method arg0) {
        if(!"query".equalsIgnoreCase(arg0.getName()))
            return 0;
        return 1;
    }
}
