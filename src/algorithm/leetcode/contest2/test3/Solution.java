package algorithm.leetcode.contest2.test3;

import java.util.Stack;

public class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int tail = s.length()-1;
        char[] chars = s.toCharArray();
        int count = 0;

        for (int i=0; i<s.length(); i++) {
            if (chars[i] == '[') {
                stack.add('[');
            } else {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    while (true) {
                        if (chars[tail] == '[') {
                            char temp = chars[i];
                            chars[i] = chars[tail];
                            chars[tail] = temp;
                            count++;
                            stack.add('[');
                            break;
                        }
                        tail--;
                    }
                }
            }
        }

        return count;
    }
}
