package algorithm.leetcode.longest_palindrome;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.longestPalindrome("babad");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        int maxLength = 0;

        for (int i=0; i<s.length(); i++) {
            String subStr = s.substring(i, i);
            int count = 0;
            int curLength = 0;

            while (checkPalindrome(subStr)) {
                curLength = subStr.length();
                count++;

                if (i+count >= s.length()) break;

                subStr = s.substring(i, i+count);
            }

            if (maxLength < curLength) {
                longestPalindrome = subStr;
            }
        }

        return longestPalindrome;
    }

    private Boolean checkPalindrome(String subString) {
        for (int i=0; i<subString.length()/2; i++) {
            if (subString.charAt(i) != subString.charAt(subString.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
