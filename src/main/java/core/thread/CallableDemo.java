package core.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 */
public class CallableDemo{

    public static void main(String[] args) {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "this is Callable's message";
            }
        };
        FutureTask futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
    }

}
