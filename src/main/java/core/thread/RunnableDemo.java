package core.thread;

/**
 * @Author tangkai009
 * @Date 2021-10-27
 * @description
 */
public class RunnableDemo {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("AAA");
            }
        });

        thread.start();
    }
}
