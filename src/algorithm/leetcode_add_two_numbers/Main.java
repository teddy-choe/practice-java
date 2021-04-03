package algorithm.leetcode_add_two_numbers;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder temp = new StringBuilder();

            while (this.next != null) {
                temp.append(val);
                this.next = next.next;
            }

            return temp.toString();
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();

        int num1 = Integer.valueOf(swapString(l1.toString()));
        int num2 = Integer.valueOf(swapString(l2.toString()));

        int sum = num1 + num2;

        String reverseNode = swapString(String.valueOf(sum));

        resultNode.val = reverseNode.charAt(0);

        for (int i=1; i<reverseNode.length(); i++) {
            ListNode newNode = new ListNode();
            ListNode tempNode = resultNode;

            newNode.val = reverseNode.charAt(i);

            while(tempNode.next != null) {
                tempNode = tempNode.next;
            }

            tempNode.next = newNode;
        }

        return resultNode;
    }

    private static String swapString(String string) {
        StringBuilder swappedString = new StringBuilder();

        for (int i=string.length()-1; i>0; i--) {
            swappedString.append(string.charAt(i));
        }

        return swappedString.toString();
    }
}
