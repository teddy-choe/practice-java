package algorithm.programmers.gem_shopping;


import java.util.HashSet;
import java.util.Hashtable;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] answer = solution.solution(gems);
        for (int ans : answer) {
            System.out.println(ans);
        }
    }

    public int[] solution(String[] gems) {
        Hashtable<String, Integer> gemList = new Hashtable<>();
        HashSet<String> gemSet = new HashSet<>();

        for (String gem: gems) {
            gemSet.add(gem);
        }

        int target = gemSet.size();
        int first = 0;
        int second = 0;
        int minLen = gems.length;
        int[] resultLen = new int[2];

        gemList.put(gems[0], 1);

        while (second != gems.length) {
            if(gemList.size() != target) {
                second++;

                if (second >= gems.length) break;

                if (gemList.containsKey(gems[second])) {
                    gemList.put(gems[second], gemList.get(gems[second]) + 1);
                } else {
                    gemList.put(gems[second], 1);
                }
            } else {
                if (minLen > second - first) {
                    minLen = second - first;
                    resultLen[0] = first + 1;
                    resultLen[1] = second + 1;
                }

                if (gemList.get(gems[first]) > 1) {
                    gemList.put(gems[first], gemList.get(gems[first]) - 1);
                } else {
                    gemList.remove(gems[first]);
                }

                first++;
            }
        }

        return resultLen;
    }
}
