package core.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tangkai009
 * @Date 2021-10-26
 * @description
 */
public class ConditionDemo {

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private String tv = "广告";

    static class Tv extends Thread {
        ConditionDemo waitDemo;

        public Tv(ConditionDemo waitDemo) {
            this.waitDemo = waitDemo;
        }

        @Override
        public void run() {
            waitDemo.waitTv();
        }
    }

    public void waitTv() {
        lock.lock();
        try {
            while (tv.equals("广告")) {
                try {
                    condition.await();
                    if (tv.equals("广告")) {
                        System.out.println(Thread.currentThread().getName() + "-" + "骗人，还是广告");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "-" + "愉快的追剧");
        }finally {
            lock.unlock();
        }
    }

    public void sendTrueMsg() {
        lock.lock();
        try {
            tv = "正剧";
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void sendFalseMsg() {
        lock.lock();
        try {
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo waitDemo = new ConditionDemo();
        Tv tv1 = new Tv(waitDemo);
        Tv tv2 = new Tv(waitDemo);
        tv1.start();
        tv2.start();
        Thread.sleep(100);
        waitDemo.sendFalseMsg();
        Thread.sleep(100);
        waitDemo.sendTrueMsg();
    }
}
