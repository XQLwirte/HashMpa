package hashByArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于Arraylist实现hashmap
 * @param <K>
 * @param <V>
 */
public class ArrayListHashMap<K, V> {
    private List<Entry<K, V>> entries = new ArrayList<Entry<K, V>>();

    /**
     * 实体类
     * @param <K>
     * @param <V>
     */
    class Entry<K, V> {
        K k;
        V v;
        Entry next;  //用于单向链表

        /**
         * 构造器
         * @param k
         * @param v
         */
        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public void put(K k, V v) {
        entries.add(new Entry<>(k, v));
    }

    public V get(K k) {
        for (Entry<K, V> entry :
                entries) {
            if (entry.k.equals(k)) {
                return entry.v;
            }
        }
        return null;
    }

    /**
     * 根据key查询时间复杂度为O(n),但不用考虑hash冲突
     * @param args
     */
    public static void main(String[] args) {
        ArrayListHashMap<String, String> arraylistHashMap = new ArrayListHashMap<>();
        arraylistHashMap.put("This is a key", "This is a value");
        arraylistHashMap.put("java father", "Ryan Gosling");
        System.out.println(arraylistHashMap.get("java father"));
    }
}
