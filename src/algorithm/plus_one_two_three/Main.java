package algorithm.plus_one_two_three;

import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i=0; i<n; i++) {
            int num = scanner.nextInt();
            dp = new int[12];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            if (num < 4) {
                System.out.println(dp[num]);
                continue;
            }

            for (int j=4; j<=num; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }

            System.out.println(dp[num]);
        }
    }
}
