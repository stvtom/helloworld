package core.collection;

public class MyHashMapTest {

    public static void main(String[] args) {

        MyHashMap<Integer,String> myHashMap = new MyHashMap();

        for (int i = 0; i <9 ; i++) {
            myHashMap.put(i,i+"V");
        }

        System.err.println(myHashMap.get(1));

        // 1.扩容
        // 2.线程安全 fail_fast modCount

    }
}
