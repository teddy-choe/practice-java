package algorithm.n_queen;

import java.util.Scanner;

public class Main {
    static int maxNum;
    static int[][] matrix;
    static int caseNum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        maxNum = scanner.nextInt();
        matrix = new int[maxNum][maxNum];

        for (int i=0; i<maxNum; i++) {
            check(i, 0);
        }

        System.out.println(caseNum);
    }

    public static void check(int row, int column) {
        for (int i=0; column-i>-1; i++) {
            if (matrix[row][column-i] == 1) {
                return;
            }

            if (row-i >= 0) {
                if (matrix[row-i][column-i] == 1) {
                    return;
                }
            }

            if (row+i < maxNum) {
                if (matrix[row+i][column-i] == 1) {
                    return;
                }
            }
        }

        if (column == maxNum - 1) {
            caseNum++;
            return;
        }

        matrix[row][column] = 1;

        for (int i=0; i<maxNum; i++) {
            check(i, column+1);
        }

        matrix[row][column] = 0;
    }
}
