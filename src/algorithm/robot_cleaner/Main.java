package algorithm.robot_cleaner;

import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int cleanCount = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        matrix = new int[n][m];
        visited = new boolean[n][m];

        int startRow = sc.nextInt();
        int startCol = sc.nextInt();
        int direction = sc.nextInt();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        doClean(startRow, startCol, direction);

        System.out.println(cleanCount);
    }

    public static void doClean(int row, int col, int directionState) {
        if (!visited[row][col]) {
            cleanCount++;
            visited[row][col] = true;
        }

        boolean isDoClean = false;

        for (int i=0; i<4; i++) {
            directionState -= 1;

            if (directionState == -1) {
                directionState = 3;
            }

            int nextRow = row + dy[directionState];
            int nextCol = col + dx[directionState];

            if (matrix[nextRow][nextCol] == 0 && visited[nextRow][nextCol] == false) {
                doClean(nextRow, nextCol, directionState);
                isDoClean = true;
                break;
            }
        }

        int backRow = row - dy[directionState];
        int backCol = col - dx[directionState];

        if (matrix[backRow][backCol] == 0 && !isDoClean) {
            doClean(backRow, backCol, directionState);
        }

        return;
    }
}
