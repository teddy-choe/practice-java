package algorithm.rotate_array;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> rotateList;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int dir = 0;
    static int preVal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];
        rotateList = new ArrayList<>();

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<l; i++) {
            int[] temp = new int[3];
            for (int j=0; j<3; j++) {
                temp[j] = sc.nextInt();
            }
            rotateList.add(temp);
        }

        for (int[] eleRotate : rotateList) {
            int r = eleRotate[0];
            int c = eleRotate[1];
            int s = eleRotate[2];

            for (int i = r-s-1; i < r+s-1; i++) {
                for (int j = c-s-1; j < c+s-1; j++) {
                    rotate(i, j, r, c, s);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += map[i][j];
            }
            if (min > sum) {
                min = sum;
            }
        }

        System.out.println(min);
    }

    public static void rotate(int row, int col, int r, int c, int s) {
        int nRow = row + dy[dir];
        int nCol = col + dx[dir];

        if (nRow < 0 || nRow > map.length - 1 || nCol < 0 || nCol > map[0].length - 1
        || nCol < c-s-1 || nCol > c+s-1 || nRow < r-s-1 || nRow > r+s-1) {
            dir = (dir + 1) % 4;
            nRow = row + dy[dir];
            nCol = col + dx[dir];
        }

//        if (nCol < c-s-1 || nCol > c+s-1 || nRow < r-s-1 || nRow > r+s-1) {
//            dir = (dir + 1) % 4;
//        }

        if (visited[nRow][nCol]) {
            return;
        }

        int temp = map[nRow][nCol];
        map[nRow][nCol] = preVal;
        preVal = temp;
        visited[nRow][nCol] = true;
        rotate(nRow, nCol, r, c, s);
    }
}
