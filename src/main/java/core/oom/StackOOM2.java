package core.oom;

/**
 * @Author tangkai009
 * @Date 2021-10-30
 * @description
 *
 * 尝试把代码修改为多线程，调整-Xss2m，
 * 因为为每个线程分配的内存越大，栈空间可容纳的线程数量越少，越容易产生内存溢出。
 * 反之，如果内存不够的情况，可以调小该参数来达到支撑更多线程的目的。
 */
public class StackOOM2 {

//    private void dontStop() {
//        while (true) {
//        }
//    }
//
//    public void stackLeakByThread() {
//        while (true) {
//            new Thread(() -> dontStop()).start();
//        }
//    }
//
//    public static void main(String[] args) throws Throwable {
//        StackOOM2 stackOOM = new StackOOM2();
//        stackOOM.stackLeakByThread();
//    }
}
