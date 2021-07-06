package algorithm.baekjun.subsequence;

import java.util.Scanner;

public class Main {
    static int[] sequence;
    static int count;
    static int num;
    static int sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        sum = scanner.nextInt();

        sequence = new int[num];

        for (int i = 0; i < num; i++) {
            sequence[i] = scanner.nextInt();
        }

        calculateSum(0, 0);

        System.out.println(count);
    }

    static void calculateSum(int index, int cur_sum) {
        if (index == num) {
            if (cur_sum == sum) {
                count++;
            }

            return;
        }

        calculateSum(index + 1, cur_sum + sequence[index]);
        calculateSum(index + 1, cur_sum);
    }
}
