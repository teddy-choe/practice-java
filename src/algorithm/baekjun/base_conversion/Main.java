package algorithm.baekjun.base_conversion;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();

        int decimal = 0;
        for (int i=r-1; i>=0; i--) {
            decimal += scanner.nextInt() * Math.pow(n, i);
        }

        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            int temp = decimal % m;
            stack.push(temp);
            decimal = decimal / m;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop() + " ");
        }

        System.out.println(stringBuilder.toString());
    }
}
