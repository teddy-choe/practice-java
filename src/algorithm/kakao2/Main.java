package algorithm.kakao2;

import java.util.Stack;

public class Main {
    public int[][] operationRank;
    int max = 0;

    public static void main(String[] args) {
        Main main = new Main();

        String expression = "100-200*300-500+20";

        System.out.println(main.solution(expression));
    }

    public long solution(String expression) {
        long answer = 0;

        operationRank = new int[][]{{0, 1, 2}, {0, 2, 1}, {1, 0, 2}, {2, 0, 1}, {1, 2, 0}, {2, 1, 0}};

        for (int i=0; i<6; i++) {
            String postfix = createPostfix(expression, operationRank[i]);
            int result = calculate(postfix);
            if (max < result) {
                max = result;
            }
        }

        answer = max;

        return answer;
    }

    public String createPostfix(String expression, int[] rank) {
        Stack<Character> stack = new Stack<>();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i=0; i<expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                stringBuffer.append(expression.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    stack.push(expression.charAt(i));
                } else {
                    char curOpe = expression.charAt(i);
                    char oldOpe = stack.peek();

                    if (calculateOperationRank(rank, curOpe) <= calculateOperationRank(rank, oldOpe)) {
                        stringBuffer.append(stack.pop().toString());
                    }

                    stack.add(curOpe);
                }
            }
        }

        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop().toString());
        }

        return stringBuffer.toString();
    }

    public int calculate(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<postfixExpression.length(); i++) {
            if (Character.isDigit(postfixExpression.charAt(i))) {
                System.out.println(Integer.valueOf(postfixExpression.charAt(i)));
                stack.push(Integer.valueOf(postfixExpression.charAt(i)));
                continue;
            }

            if (postfixExpression.charAt(i) == '+') {
                int n1 = stack.pop();
                int n2 = stack.pop();

                stack.push(n1+n2);
            }

            if (postfixExpression.charAt(i) == '-') {
                int n1 = stack.pop();
                int n2 = stack.pop();

                stack.push(n1-n2);
            }

            if (postfixExpression.charAt(i) == '*') {
                int n1 = stack.pop();
                int n2 = stack.pop();

                stack.push(n1*n2);
            }
        }

        return stack.pop();
    }

    public int calculateOperationRank(int[] rank, char operation) {
        if (operation == '+') {
            return rank[0];
        }

        if (operation == '-') {
            return rank[1];
        }

        return rank[2];
    }
}
