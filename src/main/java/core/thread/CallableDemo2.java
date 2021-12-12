package core.thread;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.*;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 */
public class CallableDemo2 {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));

        Future<String> future = poolExecutor.submit(() -> {
            System.err.println("AAAA");
            Thread.sleep(1000);
            return "future跑起来了";
        });
        System.err.println("BBB");
        System.err.println(future.get());
        System.err.println("CCC");
    }
}
