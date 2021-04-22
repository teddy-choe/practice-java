package algorithm.leetcode_sort_list;

import java.util.PriorityQueue;

public class Main {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        ListNode resultList;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        ListNode temp = head;
        while (temp.next != null) {
            priorityQueue.add(temp.val);
            temp = head.next;
        }

        ListNode newNode = new ListNode();
        resultList = newNode;

        while (!priorityQueue.isEmpty()) {
            ListNode tempNode = new ListNode(priorityQueue.poll());
            newNode.next = tempNode;
            newNode = newNode.next;
        }

        return resultList;
    }
}
