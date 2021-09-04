package algorithm.leetcode.contest4.test1;

public class Solution {
    public int findMiddleIndex(int[] nums) {
        if (nums.length == 1) return 0;

        for (int i=0; i<nums.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j=0; j<nums.length; j++) {
                if (i==j) continue;

                if (j > i) {
                    rightSum += nums[j];
                } else {
                    leftSum += nums[j];
                }
            }

            if (rightSum == leftSum) return i;
        }

        return -1;
    }
}
