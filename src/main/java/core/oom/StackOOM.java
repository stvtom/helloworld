package core.oom;

/**
 * @Author tangkai009
 * @Date 2021-10-30
 * @description
 *
 * 栈是线程私有，它的生命周期和线程相同。
 * 每个方法在执行的同时都会创建一个栈帧用于存储局部变量表、
 * 操作数栈、动态链接、方法出口等信息，方法调用的过程就是栈帧入栈和出栈的过程。
 */
public class StackOOM {

    private int length = 1;

    public void stackTest() {
//        System.out.println("stack lenght=" + length);
        length++;
        stackTest();
    }

    public static void main(String[] args) {
        StackOOM test = new StackOOM();
        test.stackTest();
    }

    //java.lang.StackOverflowError
}
