package algorithm.leetcode_remove_nth_node;

public class Main {
    public static void main(String[] args) {

    }

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

        public int getLength() {
            int len = 0;

            ListNode temp = this;

            while(temp.next != null) {
                temp = temp.next;
                len++;
            }

            return len;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode result = head;

            if (head.getLength() == 1) {
                return new ListNode();
            }

            int totalIndex = head.getLength() - n;

            for (int i=0; i<totalIndex-1; i++) {
                head = head.next;
            }

            head.next = head.next.next;

            return result;
        }
    }
}
