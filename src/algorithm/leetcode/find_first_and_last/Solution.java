package algorithm.leetcode.find_first_and_last;

public class Solution {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);

        for (int r : result) {
            System.out.println(r);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result;

        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        binarySearch(nums, 0, nums.length-1, target);

        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
            result = new int[]{-1, -1};
        } else {
            result = new int[]{min, max};
        }

        return result;
    }

    public void binarySearch(int[] nums, int start, int end, int target) {
        while (start<=end) {
            int mid = (start + end) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                min = Math.min(min, mid);
                max = Math.max(max, mid);

                binarySearch(nums, start, mid-1, target);
                binarySearch(nums, mid+1, end, target);

                return;
            }
        }
    }
}
