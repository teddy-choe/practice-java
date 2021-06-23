package algorithm.make_one;

import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i=2; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            int temp;

            if (i % 3 == 0) {
                temp = dp[i/3] + 1;
                if (temp < min) {
                    min = temp;
                }
            }

            if (i % 2 == 0) {
                temp = dp[i/2] + 1;
                if (temp < min) {
                    min = temp;
                }
            }

            temp = dp[i-1] + 1;
            if (temp < min) {
                min = temp;
            }

            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
