package algorithm.leetcode.sum_of_digits;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLucky("zbax", 2));
    }

    public int getLucky(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            stringBuilder.append((int)s.charAt(i) - 96);
        }

        String str = stringBuilder.toString();
        int result = 0;

        for (int i=0; i<k; i++) {
            result = 0;
            for (int j=0; j<str.length(); j++) {
                result += Integer.parseInt(String.valueOf(str.charAt(j)));
            }
            str = String.valueOf(result);
        }

        return result;
    }
}
