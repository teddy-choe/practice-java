package algorithm.leetcode.leetcode_swap_node;

public class Main {
    public static void main(String[] args) {

    }
}

class ListNode {
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

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode listPtr = head;

        while (listPtr.next != null ) {
            ListNode temp = listPtr;
            listPtr = listPtr.next;
            temp.next = listPtr.next;
            listPtr.next = temp;
            listPtr = temp.next;

            if (listPtr != null && listPtr.next != null) {
                temp.next = listPtr.next;
            }
        }

        return head;
}
}
