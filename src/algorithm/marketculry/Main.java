package algorithm.marketculry;

import java.util.Scanner;

public class Main {
    static long cache[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        cache = new long[length];
        String path = scanner.nextLine();
        char[] paths = path.toCharArray();

        System.out.println(move(paths, length-1));
    }

    private static long move(char[] paths, int index) {
        if (paths[index] == '0') {
            return 0;
        }

        if (index == 0 || index == 1) {
            return 1;
        }

        if (cache[index] != 0) {
            return cache[index];
        } else {
            return cache[index] = move(paths, index-1) + move(paths, index-2);
        }
    }
}
