package core.oom;


/**
 * @Author tangkai009
 * @Date 2021-10-30
 * @description
 * https://www.yuque.com/u12074004/cwux37/kxnpfq#VK1Yj
 * 方法区（元空间）是线程共享的区域，包含Class文件信息、运行时常量池、常量池
 */
public class MetaspaceOOM {

    private static String str = "test";

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        while (true) {
            String str2 = str + str;
            str = str2;
//            list.add(str.intern());
        }
    }
}
