package hashByArrayAndLink;

public class ArrayLinkHashMap<K,V> {
    private Entry[] objects = new Entry[10000];

    class Entry<K, V> {
        public K k;
        public V v;
        Entry next;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public void put(K k, V v) {
        //查询索引，如果为null将null放在数组首位，即index为0
        int index = k == null ? 0 : k.hashCode() % objects.length;
        Entry<K, V> oldEntry = objects[index];
        // 判断是否存在
        if (objects[index] == null) {
            objects[index] = new Entry<>(k, v);
        } else {
            // 发生hash碰撞则存放到链表后面
            oldEntry.next = new Entry<>(k, v);
        }
    }

    public V get(K k) {
        int index = k == null ? 0 : k.hashCode() % objects.length;
        //循环，查找数组index对应下的链表（链地址法解决hash冲突）
        for (Entry<K, V> oldEntry = objects[index]; oldEntry != null; oldEntry = oldEntry.next) {
            if (oldEntry.k == null || oldEntry.k.equals(k)) {
                return oldEntry.v;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayLinkHashMap<Object, String> hashMap = new ArrayLinkHashMap<>();
        hashMap.put("a", "a");
        hashMap.put(97, "97");
        hashMap.put(null, "This is the value of null");
        System.out.println(hashMap.get(97));

    }
}
