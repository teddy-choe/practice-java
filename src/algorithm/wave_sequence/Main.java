package algorithm.wave_sequence;

import java.util.Scanner;

public class Main {
    static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        dp = new long[100];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        for (int i=0; i<testCase; i++) {
            int index = scanner.nextInt();
            System.out.println(search(index-1));
        }
    }

    public static long search(int index) {
        if (dp[index] != 0) {
            return dp[index];
        } else {
            return dp[index] = search(index-1) + search(index-5);
        }

        // this case, non dp. there's too many duplicated caculation
//        if (index == 0 || index == 1 || index == 2) {
//            return 1;
//        }
//
//        if (index == 3 || index == 4) {
//            return 2;
//        }
//
//        return search(index-1) + search(index-5);
    }
}
