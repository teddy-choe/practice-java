package algorithm.leetcode.combination_sum;

import java.util.*;

class Solution {
    private Set<List<Integer>> result;

    public static void main(String[] args) {
        int[] candidates = {1};
        int target = 1;
        Solution solution = new Solution();
        List<List<Integer>> list = solution.combinationSum(candidates,target);

        for (List<Integer> l : list) {
            for (Integer num : l) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new HashSet<>();

        backTracking(new ArrayList<Integer>(), candidates, 0, target);

        return new ArrayList<>(result);
    }

    public void backTracking(ArrayList<Integer> list, int[] candidates,int sum, int target) {
        if (sum > target) return;
        if (sum == target) {
            Collections.sort(list);
            result.add(list);
            return;
        }

        for (int i=0; i<candidates.length; i++) {
            ArrayList<Integer> next = (ArrayList<Integer>) list.clone();
            next.add(candidates[i]);
            backTracking(next, candidates, sum + candidates[i], target);
        }
    }
}
