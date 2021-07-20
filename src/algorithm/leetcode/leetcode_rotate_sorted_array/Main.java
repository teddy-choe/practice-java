package algorithm.leetcode.leetcode_rotate_sorted_array;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {1};
        int target = 3;
        System.out.println(main.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int result = -1;
        int pivot;
        int start = 0;
        int end = nums.length-1;

        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[start] > nums[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        pivot = (start + end) / 2;

        if (pivot == 0) {
            pivot = nums.length-1;
        }

        start = 0;
        end = pivot;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        start = pivot;
        end = nums.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return result;
    }
}
