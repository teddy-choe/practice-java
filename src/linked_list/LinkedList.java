package linked_list;

public class LinkedList {
    class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public <T> void add(T data, int position) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node tempHead = head;

            for (int i=0; i<position-1; i++) {
                tempHead = head.next;
            }

            if (tempHead.next == null) {
                tempHead.next = newNode;
                tail = newNode;
            } else {
                newNode.next = tempHead.next;
                tempHead.next = newNode;
            }
        }
    }

    public void remove(int position) {
        if (head == null) {
            System.out.println("No Node!");
        } else {
            Node tempHead = head;

            for (int i=0; i<position-1; i++) {
                tempHead = head.next;
            }

            Node toRemoveNode = tempHead.next;
            tempHead.next = toRemoveNode.next;
            toRemoveNode = null;

            if (tempHead.next == null) tail = tempHead;
        }
    }

    public Node get(int position) {
        if (head == null) {
            System.out.println("No Node!");
            return null;
        } else {
            Node tempHead = head;
            for (int i=0; i<position; i++) {
                tempHead = tempHead.next;
            }

            return tempHead;
        }
    }

    public void print() {
        int index = 0;
        boolean flag = false;
        Node tempHead = head;

        if (tempHead == null) {
            System.out.println("No Node!");
            return;
        }

        while(!flag) {
            System.out.println("position: " + index++ + " data: " + tempHead.data);

            if (tempHead.next == null) {
                flag = true;
            }

            tempHead = head.next;
        }
    }
}
