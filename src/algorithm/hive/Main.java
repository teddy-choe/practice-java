package algorithm.hive;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        if (num == 1) {
            System.out.println(1);
            return;
        }

        int index = 1;
        int start = 2;

        while (true) {
            start += 6*(index-1);
            int next = start + 6*(index);

            if (num>=start && num<next) {
                break;
            }

            index++;
        }

        System.out.println(index+1);
        return;
    }
}
