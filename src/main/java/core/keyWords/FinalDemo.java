package core.keyWords;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangkai009
 * @Date 2021-11-03
 * @description
 * 1、用来修饰一个引用
 *  如果引用为基本数据类型，则该引用为常量，该值无法修改；
 *  如果引用为引用数据类型，比如对象、数组，则该对象、数组本身可以修改，但指向该对象或数组的地址的引用不能修改。
 *  如果引用时类的成员变量，则必须当场赋值，否则编译会报错。
 * 2.用来修饰一个方法
 *  当使用final修饰方法时，这个方法将成为最终方法，无法被子类重写。但是，该方法仍然可以被继承。
 * 3.用来修饰类
 *  当用final修改类时，该类成为最终类，无法被继承。简称为“断子绝孙类”。
 */
public class FinalDemo {

    final static String str = "aaaa";

    final static List<Integer> list = new ArrayList<>();
    /**
     * final关键字提高了性能。JVM和Java应用都会缓存final变量。
     * final变量可以安全的在多线程环境下进行共享，而不需要额外的同步开销。
     * 使用final关键字，JVM会对方法、变量及类进行优化。
     */
    public static void main(String[] args) {

        //会报错 不能对final变量赋值
//        str = "";

        list.add(1);

        //会报错 不能赋值
//        list = null;
    }

}

