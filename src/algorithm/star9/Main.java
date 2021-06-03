package algorithm.star9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int length = 2*n-1;

        for (int i=0; i<length; i++) {
            int first = i;
            int second = length-i;
            for (int j=0; j<length; j++) {
                int big = Math.max(first, second-1);
                if (j > big) {
                    break;
                }
                if ((j >= second-1 && j <= first) || (j >= first && j < second)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            if (i == length-1) {
                return;
            }

            System.out.println();
        }
    }
}
