package algorithm.baekjun.sum_of_two_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long t = scanner.nextInt();
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];

        for (int i=0; i<m; i++) {
            b[i] = scanner.nextInt();
        }

        ArrayList<Long> aList = new ArrayList<>();
        ArrayList<Long> bList = new ArrayList<>();

        calculateSumOfSequence(aList, a);
        calculateSumOfSequence(bList, b);

        Collections.sort(bList);

        long count = 0;
        for (long num : aList) {
            count += calculateRangeOfValidValue(t-num, bList);
        }

        System.out.println(count);
    }

    static void calculateSumOfSequence(ArrayList<Long> list, int[] numList) {
        for (int i=0; i<numList.length; i++) {
            long sum = 0;
            for (int j=i; j<numList.length; j++) {
                sum += numList[j];
                list.add(sum);
            }
        }
    }

    static int calculateRangeOfValidValue(long target, ArrayList<Long> b) {
        int left = 0;
        int right = 0;

        int start = 0;
        int end = b.size()-1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (b.get(mid) >= target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        left = end;
        start = 0;
        end = b.size()-1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (b.get(mid) <= target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        right = end;

        return right - left;
    }
}
