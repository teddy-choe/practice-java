package algorithm.triple_step;

import java.util.Scanner;

public class Main {
    private static int cache[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        cache = new int[input+1];

        System.out.println(calculateStep(input));
    }

    private static int calculateStep(int num) {
        if (num == 1) {
            return 1;
        }

        if (num == 2) {
            return 2;
        }

        if (num == 3) {
            return 4;
        }

        if (cache[num] != 0) {
            return cache[num];
        } else {
            return cache[num] = calculateStep(num-1) + calculateStep(num-2) + calculateStep(num-3);
        }
    }
}
