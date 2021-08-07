package springXml.aop.cglibDynamic;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.NoOp;

public class CallbackFilterDemo {

    public static void main(String[] args) {

        new CallbackFilterDemo().run();
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
        en.setCallbacks(new Callback[]{methodInterceptor, NoOp.INSTANCE});
        en.setCallbackFilter(new MyCallbackFilter());
        //生成代理实例
        return (UserDao)en.create();
    }

}
