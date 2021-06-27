package algorithm.baekjun.gridRobot;

import java.util.Scanner;

public class Main {
    static int[][] grid;
    static int[][] cache;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        grid = new int[num][num];
        cache = new int[num][num];

        for (int i=0; i<num; i++) {
            for (int j=0; j<num; j++) {
                grid[i][j] = 1;
                cache[i][j] = -1;
            }
        }

        for (int i=0; i<2; i++) {
            int row = Integer.valueOf(scanner.next());
            int column = Integer.valueOf(scanner.next());

            grid[row][column] = -1;
        }

        System.out.println(search(num-1, num-1));

    }

    public static int search(int row, int column) {
        if (row == 0 && column == 0) {
            return 1;
        }

        if (row < 0 || column < 0) {
            return 0;
        }

        if (grid[row][column] == -1) {
            return 0;
        }

        if (cache[row][column] == -1) {
            cache[row][column] = search(row-1, column) + search(row, column-1);
        }

        return cache[row][column];
    }
}
