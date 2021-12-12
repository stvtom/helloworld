package core.thread;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 */
public class JionDemo {

    public static void main(String[] args) throws Exception{

        Thread thread = new Thread(()->{
            System.err.println("AAA");
        });
        thread.start();
        thread.join();
        //相当于下面的代码
//        while (thread.isAlive()) {
//            wait(0);
//        }
        System.err.println("BBB");

    }
}
