package algorithm.leetcode.largest_number;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] change = {6,7,9,7,4,0,3,4,4,7};
        System.out.println(solution.maximumNumber("214810", change));
    }

    public String maximumNumber(String num, int[] change) {
        int start = -1;
        int end = -1;
        for (int i=0; i<num.length(); i++) {
            int cur = Integer.parseInt(String.valueOf(num.charAt(i)));

            if (cur < change[cur]) {
                start = i;
                end = i;

                int index = i;
                while (true) {
                    if (index >= num.length()) {
                        break;
                    }

                    int next = Integer.parseInt(String.valueOf(num.charAt(index)));
                    if (next <= change[next]) {
                        end = index++;
                    } else {
                        break;
                    }
                }

                break;
            }
        }

        String result = "";
        for (int i=0; i<num.length(); i++) {
            if (i >= start && i <= end) {
                result += String.valueOf(change[Integer.parseInt(String.valueOf(num.charAt(i)))]);
            } else {
                result += num.charAt(i);
            }
        }

        return result;
    }
}
