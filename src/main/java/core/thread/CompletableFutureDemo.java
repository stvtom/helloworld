package core.thread;

import java.util.concurrent.CompletableFuture;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {

        CompletableFuture.allOf(
                CompletableFuture.runAsync(()->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.err.println("AAA");
                }),
                CompletableFuture.runAsync(()->{
                    System.err.println("BBB");
                })
        ).join();
        System.err.println("CCC");
    }

}
