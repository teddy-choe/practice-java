package algorithm.leetcode_longest_substring;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String s = "a";

        int count = lengthOfLongestSubstring(s);

        System.out.println(count);
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxRef = 0;

        for (int i=0; i<s.length(); i++) {
            HashMap<Character, Integer> refTable = new HashMap<>();
             int tempRef = 0;

            for (int j=i; j<s.length(); j++) {
                char c = s.charAt(j);

                if (refTable.containsKey(c)) {
                    break;
                }

                refTable.put(c, 0);
                tempRef++;
            }

            if (maxRef < tempRef) {
                maxRef = tempRef;
            }
        }

        return maxRef;
    }
}
