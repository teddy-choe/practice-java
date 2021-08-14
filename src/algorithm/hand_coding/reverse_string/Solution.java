package algorithm.hand_coding.reverse_string;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseStack("abcdefg"));
        System.out.println(reverseSwap("abcdefg"));
    }

    public static String reverseStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            stack.add(s.charAt(i));
        }

        String result = "";

        for (int i=0; i<s.length(); i++) {
            result += stack.pop();
        }

        return result;
    }

    public static String reverseSwap(String s) {
        char[] chars = s.toCharArray();

        for (int left=0; left<s.length() / 2; left++) {
            int right = (s.length() - 1) - left;
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }

        return String.valueOf(chars);
    }
}
