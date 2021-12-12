package core.collection;

import java.util.Objects;

import static java.util.Objects.hash;

/**
 * Java Object.hashCode()方法
 * https://blog.csdn.net/jediael_lu/article/details/76686992
 */
public class Hash {

    public static int hashcode(int i){
        return (i%8)^5;
    }

    public static int hashcode(String s){
        int hascode = 0;
        char[]chs = s.toCharArray();
        for (char c :chs){
            hascode += hashcode(c);
        }
        return hascode;
    }

    public static void main(String[] args) {

        System.err.println(hashcode(10));
        System.err.println(hashcode(11));
        System.err.println(hashcode(12));
        System.err.println(hashcode(13));
        System.err.println(hashcode(14));
    }
}
