package algorithm.baekjun.sum_sum;

import java.util.Scanner;

public class Main {
    static int num;
    static long sum;
    static int min;
    static int[] sequence;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        sum = scanner.nextInt();

        min = num+1;
        sequence = new int[num];

        for (int i=0; i<num; i++) {
            sequence[i] = scanner.nextInt();
        }

        int total = sequence[0];
        int first = 0;
        int second = 0;

        while (true) {
            if (total >= sum) {
                min = Math.min(min, second - first + 1);
                total -= sequence[first++];
            } else {
                // second가 끝에 있는데 sum보다 작으면 이보다 더 늘어날 수는 없으므로 바로 종료한다
                if (second == sequence.length-1) break;

                total += sequence[++second];
            }

            // first가 second보다 커진다는 것은 최소 구간이 1인 지점을 지났다는 것이므로 바로 종료한다
            if (first > second) break;
        }

        if (min == num+1) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
