package core.thread;


/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 *
 *1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象；
 *2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象；
 *3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象；
 *4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。
 */
public class WaitDemo {

    public static void main(String[] args) throws Exception{
        WaitDemo waitDemo = new WaitDemo();

        new Thread(()->{
            try {
                waitDemo.getWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                waitDemo.getNotify();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public synchronized void getWait() throws Exception{
        this.wait();
        System.err.println("AAA");
    }

    public synchronized void getNotify() throws Exception{
        System.err.println("唤醒wait线程");
        this.notify();
    }

}
