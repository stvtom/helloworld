package core.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tangkai009
 * @Date 2021-10-25
 * @description
 * JVM参数-XX:+HeapDumpOnOutOfMemoryError使用方法
 * /Users/tangkai/IdeaProjects/helloworld/src/main/java/core/demo
 *
 * mac平台下怎么分析java堆hprof文件
 * https://blog.csdn.net/Prepared/article/details/115589701
 * jhat java_pid73912.hprof
 */
public class HeapOOM {
    /**
     * @param args
     * -Xms2m -Xmx2m
     * -XX:+HeapDumpOnOutOfMemoryError
     * -XX:+PrintGCTimeStamps -XX:+PrintGCDetails -Xloggc:gc.log
     * -XX:HeapDumpPath=/Users/tangkai/IdeaProjects/helloworld/src/main/java/core/demo
     */
    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOM());
        }
    }
}
