package core.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger的ABA问题
 * @Author tangkai009
 * @Date 2021-10-23
 * @description
 */
public class Atomic {

    public static void main(String[] args) {

        ExecutorService executor = new ThreadPoolExecutor(1000, 1000, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10000),
                new ThreadFactoryBuilder().setNameFormat("listen-accountForbidden-thread-%d")
                        .setUncaughtExceptionHandler((t, e) -> {
                        }).build());
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 10000; i++) {
            executor.submit(()->{
                atomicInteger.getAndIncrement();
            });
            executor.submit(()->{
                atomicInteger.getAndDecrement();
            });
            System.err.println(atomicInteger.get());
        }
        System.err.println("========================");
        System.err.println(atomicInteger.get());

    }
}
