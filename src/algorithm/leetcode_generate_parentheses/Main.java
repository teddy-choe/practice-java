package algorithm.leetcode_generate_parentheses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Main {
    private static List<String> perList;

    public static void main(String[] args) {
        Main main = new Main();
        List<String> result = main.generateParenthesis(3);

        Iterator<String> iterator = result.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        perList = new ArrayList<>();

        char[] input = new char[n*2];

        for (int i=0; i<n*2; i += 2) {
            input[i] = '(';
            input[i+1] = ')';
        }

        permutation(input, 0, input.length-1);

        Iterator<String> iterator = perList.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            boolean isRightParentheses = checkParentheses(next);

            if (isRightParentheses) {
                resultList.add(next);
            }
        }

        return resultList;
    }

    public void permutation(char[] array, int start, int end) {
        if (start == end) {
            StringBuilder stringBuilder = new StringBuilder();

            for (char ch: array) {
                stringBuilder.append(ch);
            }

            perList.add(stringBuilder.toString());
            return;
        }

        for (int i=start; i<=end; i++) {
            swap(array, start, i);
            permutation(array, start+1, end);
            swap(array, start, i);
        }
    }

    private void swap(char[] array, int preIndex, int postIndex) {
        char temp = array[preIndex];
        array[preIndex] = array[postIndex];
        array[postIndex] = temp;
    }

    public boolean checkParentheses(String inputParentheses) {
        Stack<Character> stack = new Stack<>();
        boolean isRightParentheses = false;
        int i;

        for (i=0; i<inputParentheses.length(); i++) {
            char cur = inputParentheses.charAt(i);

            if (cur == '(') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    break;
                } else if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else {
                    break;
                }
            }
        }

        if (i == inputParentheses.length() && stack.isEmpty()) {
            isRightParentheses = true;
        }

        return isRightParentheses;
    }
}
