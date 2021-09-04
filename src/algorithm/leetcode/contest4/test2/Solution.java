package algorithm.leetcode.contest4.test2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];

        for (int i=0; i<land.length; i++) {
            for (int j=0; j<land[0].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    // find land group
                    int[] group = new int[4];
                    group[0] = i;
                    group[1] = j;

                    int[] end = bfs(i, j, visited, land);

                    group[2] = end[0];
                    group[3] = end[1];

                    list.add(group);
                }
            }
        }

        int[][] result = new int[list.size()][4];

        int count = 0;
        for (int[] temp : list) {
            result[count][0] = temp[0];
            result[count][1] = temp[1];
            result[count][2] = temp[2];
            result[count][3] = temp[3];

            count++;
        }

        return result;
    }

    int[] bfs(int row, int col, boolean[][] visited, int[][] land) {
        int[] result = new int[2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i=0; i<4; i++) {
                int nRow = cur[0] + dy[i];
                int nCol = cur[1] + dx[i];

                if (nRow < 0 || nRow >= visited.length || nCol < 0 || nCol >= visited[0].length) {
                    continue;
                }

                if (!visited[nRow][nCol] && land[nRow][nCol] == 1) {
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
            }

            result[0] = cur[0];
            result[1] = cur[1];
        }

        return result;
    }
}
