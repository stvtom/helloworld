package servlet;

// 密码是 yn8ptaan
public class Block {

    {
        int a = 1;
        getName("哈哈");
    }
    static {
        int b = 100;
        getAge("哈哈哈");
    }

    public String getName(String name){
        System.err.println("这是一个测试"+name);
        return name;
    }

    public static String getAge(String name){
        System.err.println("这是一个测试"+name);
        return name;
    }

    public synchronized void getSyn1(){
        System.err.println("锁1");
    }

    public synchronized void getSyn2(){
        System.err.println("锁2");
    }

    synchronized void get(){

        synchronized (this){

        }

        synchronized (resouce){

        }
    }

    private String resouce;
}
