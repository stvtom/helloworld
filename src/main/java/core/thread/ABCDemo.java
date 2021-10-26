package core.thread;

/**
 * @Author tangkai009
 * @Date 2021-10-26
 * @description
 */
public class ABCDemo {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程执行");
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        try {
            //主线程开始等待子线程thread1，thread2
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //等待两个线程都执行完（不活动）了，才执行下行打印
        System.out.println("执行完毕");
    }
}
