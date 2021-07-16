package algorithm.baekjun.coin_zero;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int left = scanner.nextInt();
        Integer[] coins = new Integer[n];

        for (int i=0; i<n; i++) {
            coins[i] = scanner.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());
        int count = 0;

        while(left > 0) {
            for (int coin : coins) {
                if (coin <= left) {
                    left -= coin;
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
