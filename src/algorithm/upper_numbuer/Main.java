package algorithm.upper_numbuer;

import java.util.Scanner;

public class Main {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        dp = new int[n][10];
        dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = dp[0][4] = dp[0][5] = dp[0][6] = dp[0][7]
                = dp[0][8] = dp[0][9] = 1;

        for (int i=1; i<n; i++) {
            for (int j=0; j<10; j++) {
                for (int w=0; w<=j; w++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][w]) % 10007;
                }
            }
        }

        int sum = 0;
        for (int i=0; i<10; i++) {
            sum = (sum + dp[n-1][i]) % 10007;
        }

        System.out.println(sum);
    }
}
