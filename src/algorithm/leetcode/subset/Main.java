package algorithm.leetcode.subset;

import java.util.Scanner;

public class Main {
    static int max = 0;
    static boolean[][] visited;
    static int[][] matrix;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        matrix = new int[row][col];
        visited = new boolean[row][col];

        for(int i=0; i< row; i++) {
            for(int j=0; j< col; j++) {
                matrix[i][j] = Integer.parseInt(scanner.next());
            }
        }

        for(int i=0; i< row; i++) {
            for(int j=0; j< col; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, matrix[i][j]);
            }
        }

        System.out.println(max);
    }

    private static void dfs(int row, int col, int count, int sum) {
        if(count == 4) {
            if(max < sum) {
                max = sum;
            }

            return;
        }

        for(int i=0; i<4; i++) {
            int nextRow = row + dy[i];
            int nextCol = col + dx[i];

            if(nextRow < 0 || nextCol <0 || nextRow >= matrix.length || nextCol >= matrix[0].length) {
                continue;
            }

            if(visited[nextRow][nextCol] == false) {
                visited[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, count+1, sum + matrix[nextRow][nextCol]);
                visited[nextRow][nextCol] = false;
            }
        }
    }
}