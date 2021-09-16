package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericTest {
    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);

        stack.addAll(integers);
    }
}
