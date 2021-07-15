package algorithm.baekjun.tree_cut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long m = scanner.nextLong();

        ArrayList<Long> trees = new ArrayList<>();
        for (int i=0; i<n; i++) {
            trees.add(scanner.nextLong());
        }

        long start = 0;
        long end = Collections.max(trees);
        while (start <= end) {
            long mid = (start + end) / 2;
            long temp = 0;

            for (Long tree : trees) {
                long temp2 = tree - mid;
                if (temp2 > 0) temp += temp2;
            }

            if (temp >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
