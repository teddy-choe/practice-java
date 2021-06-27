package algorithm.baekjun.baby_shark;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[][] visited;
    static int[][] matrix;
    static int fishCount = 0;
    static int totalSecond = 0;
    static int sharkRow = 0;
    static int sharkCol = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static class PointAndTime {
        int row;
        int col;
        int time;

        public PointAndTime(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        matrix = new int[n][n];
        visited = new boolean[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int num = sc.nextInt();
                matrix[i][j] = num;

                if (num == 9) {
                    sharkRow = i;
                    sharkCol = j;
                }
            }
        }

        int sharkSize = 2;

        while (searchFish(sharkRow, sharkCol, sharkSize)) {
            fishCount++;

            if (fishCount == sharkSize) {
                sharkSize++;
                fishCount = 0;
            }
        }

        System.out.println(totalSecond);
    }

    public static boolean searchFish(int row, int col, int sharkSize) {
        Queue<PointAndTime> q = new LinkedList();

        for (int i=0; i<visited.length; i++) {
            for (int j=0; j<visited.length; j++) {
                visited[i][j] = false;
            }
        }

        q.offer(new PointAndTime(row, col, 0));
        visited[row][col] = true;

        while(!q.isEmpty()){
            PointAndTime temp = q.poll();

            if (matrix[temp.row][temp.col] < sharkSize && matrix[temp.row][temp.col] != 0) {
                matrix[temp.row][temp.col] = 0;
                sharkRow = temp.row;
                sharkCol = temp.col;
                totalSecond += temp.time;
                return true;
            }

            for(int i = 0; i<4; i++) {
                int nextRow = temp.row + dy[i];
                int nextCol = temp.col + dx[i];

                if (nextRow < 0 || nextCol < 0 || nextRow > matrix.length - 1 || nextCol > matrix.length - 1) {
                    continue;
                }

                if(visited[nextRow][nextCol] == false && matrix[nextRow][nextCol] <= sharkSize){
                    q.offer(new PointAndTime(nextRow, nextCol, temp.time + 1));
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return false;
    }

}
