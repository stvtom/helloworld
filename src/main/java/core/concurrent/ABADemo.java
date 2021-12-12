package core.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author tangkai009
 * @Date 2021-10-23
 * @description
 */

/*
 *ABA问题的解决 --> AtomicStampedReference
 */
public class ABADemo {

    static AtomicReference atomicReference = new AtomicReference(100);
    static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(100, 1);

    public static void main(String[] args) {
        System.out.println("-------------------ABA问题产生-------------------");

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);//A->B
            atomicReference.compareAndSet(101, 100);//B->A
        }, "t1").start();

        new Thread(() -> {
            //t2暂停一秒钟，保证ABA结束
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //true
            System.out.println("t2的修改结果: \t" + atomicReference.compareAndSet(100, 1048) + "\t" + atomicReference.get());
        }, "t2").start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------ABA问题解决-------------------");
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            //等待t4获取到相同的版本号
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            System.out.println("t3的修改结果: \treference:" + atomicStampedReference.getReference() + "\t" + "stamp:" + atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1);
            System.out.println("t3的修改结果: \treference:" + atomicStampedReference.getReference() + "\t" + "stamp:" + atomicStampedReference.getStamp());
        }, "t3").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            //等待t3完成ABA
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t4的修改结果: \t" + atomicStampedReference.compareAndSet(100, 1024, atomicStampedReference.getStamp(), atomicStampedReference.getStamp()+1));
            System.out.println("最终结果: \t\treference:" + atomicStampedReference.getReference() + "\t" + "stamp:" + atomicStampedReference.getStamp());
        }, "t4").start();
    }
}