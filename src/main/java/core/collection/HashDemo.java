package core.collection;

import java.util.Objects;

import static java.util.Objects.hash;

/**
 * Java Object.hashCode()方法
 * https://blog.csdn.net/jediael_lu/article/details/76686992
 */
public class HashDemo {

    public static void main(String[] args) {

        int i = hash(10) % 4;
        int hash = Objects.hash(10);
        int hash1 = Objects.hash(10);
        System.err.println(hash1);
        System.err.println(hash);
        System.err.println(i);

    }
}
