package springXml.aop.cglibDynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class MethodInterceptorDemo {

    public static void main(String[] args) {

        new MethodInterceptorDemo().run();
    }

    private void run() {
        UserDao userDao = getProxyInstance(new AopInterceptor());
        userDao.insert();
        userDao.query();
    }

    public UserDao getProxyInstance(MethodInterceptor methodInterceptor){
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(UserDao.class);
        en.setCallback(methodInterceptor);
        //生成代理实例
        return (UserDao)en.create();
    }

}
