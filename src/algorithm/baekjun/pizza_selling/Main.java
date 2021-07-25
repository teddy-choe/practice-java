package algorithm.baekjun.pizza_selling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] a = new int[m];
        int[] b = new int[n];

        int totalA = 0;
        for (int i=0; i<m; i++) {
            a[i] = scanner.nextInt();
            totalA += a[i];
        }

        int totalB = 0;
        for (int i=0; i<n; i++) {
            b[i] = scanner.nextInt();
            totalB += b[i];
        }

        ArrayList<Integer> subSumOfA = new ArrayList<>();
        ArrayList<Integer> subSumOfB = new ArrayList<>();
        subSumOfA.add(0);

        calculateSubSumOfPizza(subSumOfA, a);
        calculateSubSumOfPizza(subSumOfB, b);

        subSumOfA.add(totalA);
        subSumOfB.add(totalB);

        Collections.sort(subSumOfB);

        int count = 0;
        for (Integer subSum : subSumOfA) {
            int target = size-subSum;

            if (target == 0) {
                count++;
                continue;
            }

            if (target > 0) {
                count += calculateRangeOfValidValue(target, subSumOfB);
            }
        }

        System.out.println(count);
    }

    static void calculateSubSumOfPizza(ArrayList<Integer> subSumList, int[] pizzas) {
        for (int i=0; i<pizzas.length; i++) {
            int sum = 0;
            for (int j=0; j<pizzas.length-1; j++) {
                int nextIdx = i+j;

                if (nextIdx >= pizzas.length) {
                    nextIdx -= pizzas.length;
                }

                sum += pizzas[nextIdx];
                subSumList.add(sum);
            }
        }
    }

    static int calculateRangeOfValidValue(int target, ArrayList<Integer> subSumList) {
        int left = 0;
        int right = 0;
        boolean flag = false;
        int start = 0;
        int end = subSumList.size()-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (subSumList.get(mid) >= target) {
                end = mid - 1;
                if (subSumList.get(mid) == target) flag = true;
            } else {
                start = mid + 1;
            }
        }

        if (!flag) return 0;

        left = start;
        start = 0;
        end = subSumList.size()-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (subSumList.get(mid) <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        right = end;

        int result = right - left + 1;

        if (result > 0) {
            return result;
        } else {
            return 0;
        }
    }
}
