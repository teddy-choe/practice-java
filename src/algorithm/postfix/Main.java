package algorithm.postfix;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[] operatorRank = {2, 2, 1, 1, 3};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String state = scanner.nextLine();

        Stack<Character> operatorStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<state.length(); i++) {
            if (Character.isAlphabetic(state.charAt(i))) {
                stringBuilder.append(state.charAt(i));
                continue;
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(state.charAt(i));
                    continue;
                }

                if (state.charAt(i) == '(') {
                    operatorStack.push(state.charAt(i));
                    continue;
                }

                if (state.charAt(i) == ')') {
                    do {
                        stringBuilder.append(operatorStack.pop());
                    } while (!operatorStack.isEmpty() && operatorStack.peek() != '(');

                    continue;
                }

                while (!operatorStack.isEmpty() && getRank(operatorStack.peek()) >= getRank(state.charAt(i))) {
                    stringBuilder.append(operatorStack.pop());
                }

                operatorStack.push(state.charAt(i));
            }
        }

        while (!operatorStack.isEmpty()) {
            stringBuilder.append(operatorStack.pop());
        }

        String result = stringBuilder.toString().replaceAll("[(]", "");
        result = result.replaceAll("[)]", "") ;

        System.out.println(result);
    }

    public static int getRank(char c) {
        switch (c) {
            case '+' :
                return 1;

            case '-' :
                return 1;

            case '*' :
                return 2;

            case '/' :
                return 2;

            case '(' :
                return 0;

            default :
                return -1;
        }
    }
}
