package algorithm.max_substraction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 0;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] array = new int[n];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i=0; i<n; i++) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            permutation(array, 0, array.length);
            System.out.println(max);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // n개중에 r개 뽑는 경우
    static void permutation(int[] array, int depth, int n) {
        if (depth == n) {
            int sum = calculate(array);

            if (sum > max) {
                max = sum;
            }

            return;
        }

        for (int i=depth; i<n; i++) {
            swap(array, depth, i);
            permutation(array, depth+1, n);
            swap(array, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static int calculate(int[] array) {
        int sum = 0;

        for (int i=0; i<array.length-1; i++) {
            sum += Math.abs(array[i] - array[i+1]);
        }

        return sum;
    }
}
