package servlet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserA {

    public static void main(String[] args) throws Exception{

        UserB userB = new UserB();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.err.println(contextClassLoader);
        Class<?> bClass = contextClassLoader.loadClass("servlet.UserB");
        System.err.println(bClass);
//        Field name = bClass.getField("name");
//        System.err.println(name);
//        Field age = bClass.getField("age");
//        System.err.println(age);
        Field[] fields = bClass.getDeclaredFields();
        for (Field field :fields){
            System.err.println(field);
        }
        Field address = bClass.getField("address");
        System.err.println(address.getName());
//        System.err.println(address.getType());
//        System.err.println(address.getDeclaringClass());
//        System.err.println(address.getGenericType());
//        System.err.println(address.getDeclaredAnnotations());
        System.err.println(address.get(userB));

        for (Field field : fields){
            field.setAccessible(true);
            System.err.println(field.get(userB));
        }

        Method[] declaredMethods = bClass.getDeclaredMethods();

        for (Method method : declaredMethods){
            method.setAccessible(true);
            System.err.println(method.getName());

            if (method.getName().equals("sing")) {
                System.err.println(method.invoke(userB, "brid"));
            }

            if (method.getName().equals("dance")){
                System.err.println(method.invoke(userB,1));
            }
        }


        UserBInterface proxyInstance = (UserBInterface) Proxy.newProxyInstance(contextClassLoader, bClass.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.invoke(proxy, args);
                return null;
            }
        });
        System.err.println(proxyInstance.getName("测试"));
    }
}

