package algorithm.leetcode_house_robber;

import java.util.Arrays;

public class Main {
    public static boolean[] isRobAble;
    public static int highestMoney = 0;

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1,2,1,1,1,1,1,1,1};
        int result = main.rob(nums);
        System.out.println(result);
    }

    public int rob(int[] nums) {
        isRobAble = new boolean[nums.length+1];
        Arrays.fill(isRobAble, true);

        robHouse(nums, 0, 0);

        return highestMoney;
    }

    public void robHouse(int[] nums, int index, int money) {
        if (index == nums.length) {
            if (highestMoney < money) {
                highestMoney = money;
            }

            System.out.println("굿");

            return;
        }

        if (!isRobAble[index]) {
            robHouse(nums, index+1, money);
        } else {
            // rob this house
            isRobAble[index] = false;
            isRobAble[index+1] = false;
            robHouse(nums, index+1, money+nums[index]);
            isRobAble[index] = true;
            isRobAble[index+1] = true;

            // not rob this house
            isRobAble[index] = false;
            robHouse(nums, index+1, money);
            isRobAble[index] = true;
        }
    }
}
