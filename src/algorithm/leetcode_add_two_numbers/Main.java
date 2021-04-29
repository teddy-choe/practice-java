package algorithm.leetcode_add_two_numbers;

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

class Main {
    public static void main(String[] args) {
        Main main = new Main();

        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(8);

        main.addTwoNumbers(l1, l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode result = temp;
        boolean overTen = false;

        while (l1 != null || l2 != null) {
            int value = l1.val + l2.val;

            if (value>=10) {
                value = value % 10;
                overTen = true;
            } else {
                overTen = false;
            }

            if (temp == null) {
                temp = new ListNode(0);
            }

            temp.val = temp.val + value;

            if (overTen) {
                temp.next = new ListNode(1);
            }

            temp = temp.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        return result;
    }
}