package algorithm.leetcode.add_two_numbers;

class Solution {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList;
        ListNode head = new ListNode();
        resultList = head;
        int postCount = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 == null) {
                int temp = l2.val;
                sum = postCount + (temp % 10);
                postCount = temp / 10;

                l2 = l2.next;
            } else if (l2 == null) {
                int temp = l1.val;
                sum = postCount + (temp % 10);
                postCount = temp / 10;

                l1 = l1.next;
            } else {
                int temp = l1.val + l2.val;
                sum = postCount + (temp % 10);
                postCount = temp / 10;

                l1 = l1.next;
                l2 = l2.next;
            }

            head = new ListNode();
            head.val = sum;
            head = head.next;
        }

        if (postCount != 0) {
            head = new ListNode();
            head.val = 1;
        }

        // 경계조건, 마지막 항목에서 더 추가해야될수도있다. 즉 길이가 1이 늘어날 수가 있음
        return resultList;
    }
}
