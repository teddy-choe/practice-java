package algorithm.baekjun.dslr;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Number {
        int num;
        String step;

        public Number(int num, String step) {
            this.num = num;
            this.step = step;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i=0; i<n; i++) {
            visited = new boolean[10001];

            int before = scanner.nextInt();
            int after = scanner.nextInt();

            String result = bfs(before, after);
            System.out.println(result);
        }
    }

    static String bfs(int before, int after) {
        Queue<Number> numbers = new LinkedList<>();
        numbers.add(new Number(before, ""));
        visited[before] = true;

        while (!numbers.isEmpty()) {
            Number number = numbers.poll();

            if (number.num == after) {
                return number.step;
            }

            int d = calD(number.num);
            if (!visited[d]) {
                visited[d] = true;
                numbers.add(new Number(d, number.step + "D"));
            }

            int s = calS(number.num);
            if (!visited[s]) {
                visited[s] = true;
                numbers.add(new Number(s, number.step + "S"));
            }

            int l = calL(number.num);
            if (!visited[l]) {
                visited[l] = true;
                numbers.add(new Number(l, number.step + "L"));
            }

            int r = calR(number.num);
            if (!visited[r]) {
                visited[r] = true;
                numbers.add(new Number(r, number.step + "R"));
            }
        }

        return "";
    }

    static int calD(int num) {
        return (num*2) % 10000;
    }

    static int calS(int num) {
        num -= 1;
        if (num == 0) {
            return 9999;
        } else {
            return num;
        }
    }

    static int calL(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    static int calR(int num) {
        return (num%10) * 1000 + num / 10;
    }
}
