package core.collection;

import java.util.*;

public class MyHashMap<K,V> {

    private Entry<K,V>[] table;

    private static final Integer  CAPACITY = 8;

    private Integer size = 0;
    public void put(K key,V value){
        if (table ==  null){
            inflate();
        }
        Integer hashcode = key.hashCode();
        Integer index = indexFor(hashcode);

        for (Entry<K,V> entry = table[index];entry != null ;entry = entry.next){
            if (entry.key.equals(key)){
                entry.value = value;
            }
        }

        addEntry(key, value, index);
    }

    private void addEntry(K key, V value, Integer index) {
        Entry<K,V> entry = new Entry<>(key,value,table[index]);
        table[index] = entry;
        size++;
    }

    private Integer indexFor(Integer hashcode) {
        return hashcode % table.length;
    }

    private void inflate() {
        table = new Entry[CAPACITY];
    }

    public V get(K key){
        Integer hashcode = key.hashCode();
        Integer index = indexFor(hashcode);

        for (Entry<K,V> entry = table[index];entry != null ;entry = entry.next){
            if (entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

    public int size(){
        return this.size;
    }


    class Entry<K,V>{
        private K key;
        private V value;

        private Entry<K,V> next;

        public Entry(K key,V value,Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}
