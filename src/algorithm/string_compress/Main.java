package algorithm.string_compress;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.solution("()))((()"));
    }

    public String solution(String p) {
        String answer = "";

        answer = check(p);

        return answer;
    }

    public String check(String p) {
        if(p.length() == 0 || isValidParenthese(p)) {
            return p;
        }

        StringBuffer result = new StringBuffer();
        StringBuffer buffer = new StringBuffer();

        for(int i=0; i<p.length(); i++) {
            buffer.append(p.charAt(i));

            if(isBalanced(buffer.toString()) && isValidParenthese(buffer.toString())) {
                result.append(buffer.toString());
                result.append(check(p.substring(i+1)));
                break;
            } else if (isBalanced(buffer.toString())) {
                result.append('(');
                result.append(check(p.substring(i+1)));
                result.append(')');
                buffer.deleteCharAt(0);
                buffer.deleteCharAt(buffer.length()-1);
                result.append(reverse(buffer.toString()));
                break;
            }
        }

        return result.toString();
    }

    public String reverse(String p) {
        StringBuffer buffer = new StringBuffer();

        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                buffer.append(')');
            } else {
                buffer.append('(');
            }
        }

        return buffer.toString();
    }

    public boolean isBalanced(String p) {
        int leftNum = 0;
        int rightNum = 0;

        for (int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                leftNum++;
            } else {
                rightNum++;
            }
        }

        if(leftNum == rightNum) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isValidParenthese(String p) {
        Stack<Character> stack = new Stack();

        for (int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                stack.push(p.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
