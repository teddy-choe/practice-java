package algorithm.leetcode.leetcode_two_sum;

public class Main {
    public static void main(String[] args) {
        int[] nums = {500000000, 500000000};
        int target = 1000000000;

        Main main = new Main();

        int[] result = main.twoSum(nums, target);

        for (int num : result) {
            System.out.println(num);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }
}
