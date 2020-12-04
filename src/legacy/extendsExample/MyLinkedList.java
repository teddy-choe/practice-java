package legacy.extendsExample;

public class MyLinkedList {

    private Node head = null;

    /*
    내부 클래스도 필드와 마찬가지로 외부클래스에서만 사용하므로 캡슐화를 위해 private화 합니다
     */
    private class Node {
        private String data;
        private Node link;

        public Node(String data) {
            this.data = data;
        }
    }

    public void add(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
        } else {
            Node next = head;
            while (next.link != null) {
                next = next.link;
            }
            next.link = newNode;
        }
    }

    public void print(){
        if (head == null){
            System.out.println("등록된 데이터가 없습니다.");
        } else {
            System.out.println("등록된 데이터는 다음과 같습니다.");
            Node next = head;
            while (next != null) {
                System.out.println(next.data);
                next = next.link;
            }
        }
    }
}
