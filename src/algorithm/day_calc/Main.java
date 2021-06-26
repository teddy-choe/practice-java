package algorithm.day_calc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int answerE = scanner.nextInt();
        int answerS = scanner.nextInt();
        int answerM = scanner.nextInt();

        int count = 0;
        int e = 0;
        int m = 0;
        int s = 0;

        while (true) {
            count++;
            e++;
            if (e >= 16) e = 1;
            s++;
            if (s >= 29) s = 1;
            m++;
            if (m >= 20) m = 1;

            if (e == answerE && s == answerS && m == answerM) {
                break;
            }
        }

        System.out.println(count);
    }
}
