package two_stack_one_queue;

import java.util.Stack;

public class StackToQueue<T> {
    private Stack<T> inputStack = new Stack<>();
    private Stack<T> outputStack = new Stack<>();

    public void push(T data) {
        inputStack.push(data);
    }

    public T pop() {
        if (outputStack.isEmpty()) {
            translate();
        }

        return outputStack.pop();
    }

    private void translate() {
        while(!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }
}
