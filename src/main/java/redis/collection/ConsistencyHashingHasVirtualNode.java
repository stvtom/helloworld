package redis.collection;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性Hash算法以及java代码实现
 * https://blog.csdn.net/ypp91zr/article/details/88993704
 *
 * 一致性Hash算法定义：
 * 在分布式集群环境当中，机器的添加、删除以及产生故障自动脱离集群这是最基本的功能，如果
 * 采用hash(o)%n的算法，在机器数量有变动的时候，以前的数据基本是找不到的。比如最开始3台
 * hash(o)%3=2  如果增加了一台hash(o)%4=?  结果肯定不会为2，如果使用hash取模，在机器数
 * 量增减的时候该问题是无法避免的。为了解决这个问题，就产生了一致性hash算法
 */
public class ConsistencyHashingHasVirtualNode {

    //待添加入Hash环的服务器列表
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111",
            "192.168.0.2:111", "192.168.0.3:111", "192.168.0.4:111"};

    //真实节点列表
    private static List<String> realNodes = new LinkedList<>();

    //虚拟节点列表
    private static SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();

    private static final int NUM_HOST = 5;

    //程序初始化，将所有的服务器放入sortedMap中
    static {
        //添加真实节点
        for (int i = 0; i < servers.length; i++) {
            realNodes.add(servers[i]);
        }
        //添加虚拟节点
        for (String str : realNodes) {
            for (int i = 1; i <= NUM_HOST; i++) {
                String nodeName = str + "VM" + String.valueOf(i);
                int hash = getHash(nodeName);
                sortedMap.put(hash, nodeName);
                System.out.println("虚拟节点hash:" + hash + "【" + nodeName + "】放入");
            }
        }
    }

    //得到应当路由到的结点
    private static String getServer(String key) {
        //得到该key的hash值
        int hash = getHash(key);
        //得到大于该Hash值的所有Map
        String host;
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        if (subMap.isEmpty()) {
            //如果没有比该key的hash值大的，则从第一个node开始
            Integer i = sortedMap.firstKey();
            //返回对应的服务器
            host = sortedMap.get(i);
        } else {
            //第一个Key就是顺时针过去离node最近的那个结点
            Integer i = subMap.firstKey();
            //返回对应的服务器
            host= subMap.get(i);
        }
        if (StringUtils.isNotBlank(host)) {
            String realHost = host.substring(0,host.indexOf("VM"));
            System.out.println(realHost);
            return realHost;
        }
        return null;
    }

    //使用FNV1_32_HASH算法计算服务器的Hash值
    private static int getHash(String str) {
//        int hash = str.hashCode();
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args) {
        String[] keys = {"天下", "无敌", "的我"};
        for (int i = 0; i < keys.length; i++) {
            System.out.println("[" + keys[i] + "]的hash值为" + getHash(keys[i]) + ", 被路由到结点[" + getServer(keys[i]) + "]");
        }
    }
}
