package algorithm.leetcode.contest2.test2;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int pile : piles) {
            priorityQueue.add(pile);
        }

        for (int i=0; i<k; i++) {
            int cur = priorityQueue.poll();
            cur -= cur/2;
            priorityQueue.add(cur);
        }

        Iterator<Integer> iterator = priorityQueue.iterator();

        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }

        return sum;
    }
}
