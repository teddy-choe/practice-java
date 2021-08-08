package algorithm.leetcode.contest1.problem1;

class Solution {
    public String makeFancyString(String s) {
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(0));

        for (int i=1; i<s.length(); i++) {
            String pre = String.valueOf(s.charAt(i-1));
            String cur = String.valueOf(s.charAt(i));

            if (pre.equals(cur)) {
                count++;

                if (count < 3) {
                    stringBuilder.append(cur);
                }
            } else {
                count = 1;
                stringBuilder.append(cur);
            }
        }

        return stringBuilder.toString();
    }
}
