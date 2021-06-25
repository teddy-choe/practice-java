package algorithm.pinary_number;

import java.util.Scanner;

public class Main {
    static long[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        dp = new long[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        System.out.println(search(n-1, 0) + search(n-1, 1));
    }

    public static long search(int n, int m) {
        if (dp[n][m] != 0 || (n == 0 && m == 0)) {
            return dp[n][m];
        }

        if (m == 0) {
            return dp[n][m] = search(n-1, 0) + search(n-1, 1);
        } else {
            return dp[n][m] = search(n-1, 0);
        }
    }
}
