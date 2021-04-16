package algorithm.test;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.solution("{"));
    }

    public int solution(String s) {
        int answer = 0;

        String turnedStr = "";
        for (int i=0; i<s.length(); i++) {
            turnedStr = makeTurnedString(s, i);
            if (checkRightParentheses(turnedStr)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean checkRightParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;

        for (int i=0; i<input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    result = false;
                    break;
                }

                if (cur == ')') {
                    if (stack.peek() != '(') {
                        result = false;
                        break;
                    }
                }

                if (cur == '}') {
                    if (stack.peek() != '{') {
                        result = false;
                        break;
                    }
                }

                if (cur == ']') {
                    if (stack.peek() != '[') {
                        result = false;
                        break;
                    }
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            result = false;
        }

        return result;
    }

    private String makeTurnedString(String input, int index) {
        if (index == 0) {
            return input;
        }

        StringBuffer stringBuffer = new StringBuffer();

        String before = input.substring(0, index);
        String after = input.substring(index);

        stringBuffer.append(after);
        stringBuffer.append(before);

        return stringBuffer.toString();
    }
}
