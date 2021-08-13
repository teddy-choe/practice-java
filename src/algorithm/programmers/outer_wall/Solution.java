package algorithm.programmers.outer_wall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weak = {1, 3, 4, 9, 10};
        int[] dist = {3, 5, 7};
        solution.solution(12, weak, dist);
    }

    int min = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        Integer boxedDist[] = Arrays.stream(dist).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedDist, Collections.reverseOrder());
        for (int i=1; i<boxedDist.length; i++) {
            combination(boxedDist, weak, n, 0, i, new ArrayList<>());
        }

        return min;
    }

    void combination(Integer[] dist, int[] weak, int n, int depth, int total, ArrayList<Integer> selected) {
        if (depth == total) {
            boolean[] visited = new boolean[n];
            for (int i=0; i<total; i++) {
                checkWall(selected.get(i), dist[i], visited);
            }

            for (int i=0; i<weak.length; i++) {
                if (!visited[weak[i]]) {
                   return;
                }
            }

            min = Math.min(min, total);
            return;
        }

        for (int item : weak) {
            ArrayList<Integer> tempList = (ArrayList<Integer>) selected.clone();
            tempList.add(item);
            combination(dist, weak, n, depth + 1, total, tempList);
        }
    }

    void checkWall(int start, int dist, boolean[] visited) {
        for (int i=0; i<=dist; i++) {
            if (start + i >= visited.length) {
                start -= visited.length;
            }
            visited[start+i] = true;
        }
    }
}
