package algorithm.tile;

import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        System.out.println(setTile(n));
    }

    static int setTile(int n) {
        if (dp[n] != 0) {
            return dp[n];
        } else {
            return dp[n] = (setTile(n-1) + setTile(n-2)) % 10007;
        }
    }
}
