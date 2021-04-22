package algorithm.subset;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<List<Integer>> subsetList;

    public static void main(String[] args) {
        Main main = new Main();

        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        List<List<Integer>> list = main.subsets(nums);

        for (List<Integer> list1 : list) {
            System.out.println();
            for (int n : list1) {
                System.out.print(n + " ");
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        subsetList = new ArrayList<>();

        // add zero set
        subsetList.add(new ArrayList<>());
        boolean[] visited = new boolean[nums.length];

        for (int i=1; i<=nums.length; i++) {
            createSubset(nums, visited, 0, nums.length, i);
        }

        return subsetList;
    }

    private void createSubset(int[] ints, boolean[] visited, int idx, int n, int r) {
        if (r == 0) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    tempList.add(ints[i]);
                }
            }

            subsetList.add(tempList);
            return;
        }

        if (idx == n) {
            return;
        }

        visited[idx] = true;
        createSubset(ints, visited, idx+1, n, r-1);

        visited[idx] = false;
        createSubset(ints, visited, idx+1, n, r);
    }
}
