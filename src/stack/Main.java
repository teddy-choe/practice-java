package stack;

public class Main {
    public static void main(String[] args) {
        LinkedListStack<String> stack = new LinkedListStack<>();

        stack.printStack();
        stack.push("1");
        stack.push("2");
        stack.printStack();
        String result = stack.pop();
        stack.push("3");
        stack.push("4");
        stack.printStack();

        System.out.println(stack.peek());
    }
}
