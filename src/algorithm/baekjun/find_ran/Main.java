package algorithm.baekjun.find_ran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        long n = scanner.nextLong();

        ArrayList<Long> lines = new ArrayList<>();
        for (int i=0; i<k; i++) {
            lines.add(scanner.nextLong());
        }

        long result = searchLength(lines, 1, Collections.max(lines), n);
        System.out.println(result);
    }

    static long searchLength(ArrayList<Long> lines, long start, long end, long n) {
        long maxLen = 0;
        while(start <= end) {
            long mid = (start + end) / 2;

            long temp = 0;
            for (Long line : lines) {
                temp += line / mid;
            }

            if (temp >= n) {
                start = mid+1;
                maxLen = Math.max(maxLen, mid);
            } else {
                end = mid-1;
            }
        }

        return maxLen;
    }
}
