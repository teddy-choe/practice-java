package algorithm.baekjun.traveling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        matrix = new int[n][n];

        for (int i=0; i<n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j=0; j<n; j++) {
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int[] array = new int[n];

        for (int i=0; i<n; i++) {
            array[i] = i+1;
        }

        permutation(array, 0, n);

        System.out.println(min);
    }

    static void permutation(int[] arr, int depth, int n) {
        if (depth == n) {
            int sum = 0;

            for (int i=0; i<arr.length-1; i++) {
                int start = arr[i];
                int end = arr[i+1];

                if (matrix[start-1][end-1] == 0) return;

                sum += matrix[start-1][end-1];
            }

            if (matrix[arr[arr.length-1]-1][arr[0]-1] == 0) return;

            sum += matrix[arr[arr.length-1]-1][arr[0]-1];

            if (min > sum) {
                min = sum;
            }

            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth+1, n);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
