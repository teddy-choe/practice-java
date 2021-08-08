package algorithm.leetcode.contest2.test1;

class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String test = "";
        for (String word : words) {
            test += word;

            if (s.equals(test)) {
                return true;
            }
        }
        return false;
    }
}
