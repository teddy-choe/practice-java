package algorithm.baekjun.bubble_sort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(bubbleSort(arr));
    }

    private static int bubbleSort(int[] arr) {
        int count = 0;

        for (int i=arr.length-1; i>0; i--) {
            boolean flag = false;

            for (int j=0; j<i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = true;
                    swap(arr, j, j+1);
                    count++;
                }
            }

            if (!flag) break;
        }

        return count;
    }

    private static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
