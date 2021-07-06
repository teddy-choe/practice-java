package algorithm.baekjun.sum_of_num;

import java.util.Scanner;

public class Main {
    static int[] sequence;
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();

        sequence = new int[n];

        for (int i=0; i<sequence.length; i++) {
            sequence[i] = scanner.nextInt();
        }

        for (int i=0; i<sequence.length; i++) {
            calculate(i, 0, s);
        }

        System.out.println(count);
    }

    static void calculate(int index, int total, int sum) {
        if (total == sum) {
            count++;
        }

        if (total > sum || index >= sequence.length) {
            return;
        }

        calculate(index+1, total + sequence[index], sum);
    }
}
