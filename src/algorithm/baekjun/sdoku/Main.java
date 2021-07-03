package algorithm.baekjun.sdoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];

        for (int i=0; i<9; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        backTracking(0,0);
    }

    static void backTracking(int row, int col) {
        if (col == 9) {
            backTracking(row+1, 0);
            return;
        }

        if (row == 9) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.exit(0);
            return;
        }

        if (map[row][col] == 0) {
            for (int i=1; i<10; i++) {
                if (isValidHorizontal(row, i) && isValidVertical(col, i) && isValidZone(row, col, i)) {
                    map[row][col] = i;
                    backTracking(row, col+1);
                }
            }

            map[row][col] = 0;
            return;
        }

        backTracking(row, col+1);
    }

    static boolean isValidHorizontal(int row, int value) {
        for (int i=0; i<9; i++) {
            int cur = map[row][i];

            if (cur == 0) continue;

            if (cur == value) {
                return false;
            }
        }

        return true;
    }

    static boolean isValidVertical(int col, int value) {
        for (int i=0; i<9; i++) {
            int cur = map[i][col];

            if (cur == 0) continue;

            if (cur == value) {
                return false;
            }
        }

        return true;
    }

    static boolean isValidZone(int row, int col, int value) {
        int zoneRow = (row / 3) * 3;
        int zoneCol = (col / 3) * 3;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                int cur = map[zoneRow + i][zoneCol + j];

                if (cur == 0) continue;

                if (cur == value) return false;
            }
        }

        return true;
    }
}
