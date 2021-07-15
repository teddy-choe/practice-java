package algorithm.baekjun.paper_num;

import java.util.Scanner;

public class Main {
    // -1 -> 0, 0 -> 1, 1 -> 2
    static int[] count = new int[3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] papers = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                papers[i][j] = scanner.nextInt();
            }
        }

        divide(papers, 0, 0, n);

        for (int num : count) {
            System.out.println(num);
        }
    }

    static void divide(int[][] papers, int row, int col, int size) {
        if (check(papers, row, col, size)) {
            int num = papers[row][col];
            count[num + 1]++;
        } else {
            int newSize = size/3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(papers, row + newSize*i, col + newSize*j, newSize);
                }
            }
        }
    }

    static boolean check(int[][] papers, int row, int col, int size) {
        int num = papers[row][col];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (papers[row + i][col + j] != num) {
                    return false;
                }
            }
        }

        return true;
    }
}
