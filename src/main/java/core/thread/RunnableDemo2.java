package core.thread;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 */
public class RunnableDemo2 {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));
        poolExecutor.execute(()->{
            System.err.println("AAAA");
        });
    }
}
