package algorithm.baekjun.repeat;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        dfs(n, p, list);

        System.out.println(answer);
    }

    public static void dfs(int num, int p, ArrayList<Integer> list) {
        char[] temp = String.valueOf(num).toCharArray();
        int next = 0;

        for (int i=0; i<temp.length; i++) {
            next += Math.pow(Integer.parseInt(String.valueOf(temp[i])), p);
        }

        if (list.contains(next)) {
            answer = list.indexOf(next);
            return;
        }

        list.add(next);
        dfs(next, p, list);
    }
}
