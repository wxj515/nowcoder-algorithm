/**
 * 题目：最主要功能是可以能够等概率地得到某个key
 * 思路：为了保证绝对的等概率，首先需要两个map，其实remove功能也需要特殊实现：也就是删除后需要吧这个洞补上
 * 拿最后的元素补，否则洞越来越多后，在随机取的时候可能一直都无法命中到具体元素，可能会需要花费大量时间去不停得试
 */
package Hash;

import java.util.HashMap;

public class RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> kIntegerHashMap;
        private HashMap<Integer, K> integerKHashMap;
        private int size;

        public Pool() {
            this.integerKHashMap = new HashMap<>();
            this.kIntegerHashMap = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key) {
            if (!kIntegerHashMap.containsKey(key)) {
                kIntegerHashMap.put(key, size);
                integerKHashMap.put(size++, key);
            }
        }

        public void delete(K key) {
            if (!kIntegerHashMap.containsKey(key)) {
                int deleteIndex = kIntegerHashMap.get(key);
                K lastkey = integerKHashMap.get(--size);
                integerKHashMap.replace(deleteIndex, lastkey);
                kIntegerHashMap.remove(key);
                kIntegerHashMap.replace(lastkey, deleteIndex);
                integerKHashMap.remove(size);
            }
        }

        public K getRandom() {
            if (size != 0) {
                int randomIndex = (int) (Math.random() * size);
                return integerKHashMap.get(randomIndex);
            }
            return null;
        }
    }
}
