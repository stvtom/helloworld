package redis.collection;

import java.util.BitSet;

/**
 * 布隆过滤器（Bloom Filter）Java实现
 * https://blog.csdn.net/acceptedxukai/article/details/7031899
 *
 * JAVA实现较完善的布隆过滤器
 * https://blog.csdn.net/u014653197/article/details/76397037
 *
 * 布隆过滤器定义：
 * 它是一种space efficient的概率型数据结构，用于判断一个元素是否在集合中。
 */
public class BloomFilter {

    private static final int DEFAULT_SIZE = 2 << 24;//布隆过滤器的比特长度
    private static final int[] seeds = {3,5,7, 11, 13, 31, 37, 61};//这里要选取质数，能很好的降低错误率
    private static BitSet bits = new BitSet(DEFAULT_SIZE);
    private static SimpleHash[] func = new SimpleHash[seeds.length];

    public static void addValue(String value)
    {
        for(SimpleHash f : func)//将字符串value哈希为8个或多个整数，然后在这些整数的bit上变为1
            bits.set(f.hash(value),true);
    }

    public static void add(String value)
    {
        if(value != null) addValue(value);
    }

    public static boolean contains(String value)
    {
        if(value == null) return false;
        boolean ret = true;
        for(SimpleHash f : func)//这里其实没必要全部跑完，只要一次ret==false那么就不包含这个字符串
            ret = ret && bits.get(f.hash(value));
        return ret;
    }

    public static void main(String[] args) {
        String value = "xkeyideal@gmail.com";
        for (int i = 0; i < seeds.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
        add(value);
        System.out.println(contains(value));
    }

}
