package algorithm.leetcode_lru_cach;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);

        lruCache.put(2, 1);
        lruCache.get(1);
        lruCache.print();
    }

    static class LRUCache {
        //TODO: 유틸을 안쓴다면?
        int maxSize = 0;
        int size = 0;
        LinkedList<Integer> linkedList;
        Hashtable<Integer, Integer> hashtable;

        public LRUCache(int capacity) {
            maxSize = capacity;
            linkedList = new LinkedList<>();
            hashtable = new Hashtable<>();
        }

        public int get(int key) {
            if (!hashtable.containsKey(key)) {
                return -1;
            }

            int recent = linkedList.indexOf(key);
            linkedList.remove(recent);
            linkedList.add(key);

            return hashtable.get(key);
        }

        public void put(int key, int value) {
            if (hashtable.containsKey(key)) {
                hashtable.replace(key, value);
                return;
            }

            if (size == maxSize) {
                int last = linkedList.poll();
                hashtable.remove(last);
                size--;
            }

            linkedList.add(key);
            hashtable.put(key, value);
            size++;
        }

        public void print() {
            Iterator<Integer> iterator = linkedList.iterator();

            while (iterator.hasNext()) {
                int next = iterator.next();

                System.out.println(next);
            }
        }
    }
}
