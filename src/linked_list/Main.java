package linked_list;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.print();

        linkedList.add(5, 0);
        linkedList.add(3, 1);
        linkedList.print();

        linkedList.add(7, 2);
        linkedList.remove(1);
        linkedList.print();

        System.out.println(linkedList.get(1).data);
    }
}
