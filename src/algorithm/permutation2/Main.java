package algorithm.permutation2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<List<Integer>> perList;

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {-2,-1,3,2,4,5};

        List<List<Integer>> list = main.permute(nums);

        for (List<Integer> temp : list) {
            for (int number: temp) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        perList = new ArrayList<>();

        permutation(nums, 0, nums.length-1);

        return perList;
    }

    public void permutation(int[] array, int start, int end) {
        if (start == end) {
            ArrayList list = new ArrayList();

            for (int num: array) {
                list.add(num);
            }

            perList.add(list);
            return;
        }

        for (int i=start; i<=end; i++) {
            swap(array, start, i);
            permutation(array, start+1, end);
            swap(array, start, i);
        }
    }

    private void swap(int[] array, int preIndex, int postIndex) {
        int temp = array[preIndex];
        array[preIndex] = array[postIndex];
        array[postIndex] = temp;
    }
}
