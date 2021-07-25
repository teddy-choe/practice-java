package algorithm.leetcode.test1;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.areOccurrencesEqual("aaaaaaabbcc");
        System.out.println(result);
    }

    public boolean areOccurrencesEqual(String s) {
        char[] stringToChar = s.toCharArray();
        Arrays.sort(stringToChar);
        String sortedStr = new String(stringToChar);

        int curCount = 0;
        int comparisonCount = 0;
        char curChar = sortedStr.charAt(0);
        for (int i=0; i<sortedStr.length(); i++) {
            char toComparison = sortedStr.charAt(i);

            if (curChar == toComparison) {
                curCount++;
                continue;
            } else {
                if (comparisonCount == 0) {
                    comparisonCount = curCount;
                    curCount = 1;
                    curChar = toComparison;
                    continue;
                } else {
                    if (comparisonCount == curCount) {
                        curCount = 1;
                        curChar = toComparison;
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }

        if (comparisonCount == 0) {
            return true;
        }

        if (comparisonCount != curCount) {
            return false;
        }

        return true;
    }
}
