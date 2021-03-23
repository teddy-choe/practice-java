package algorithm.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int[][] matrix;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> section = new ArrayList<>();

        int num = scanner.nextInt();
        scanner.nextLine();
        matrix = new int[num][num];
        visited = new boolean[num][num];

        for (int i = 0; i < num; i++) {
            String temp = scanner.nextLine();
            for (int j = 0; j < num; j++) {
                matrix[i][j] = temp.charAt(j) - 48;
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (matrix[i][j] == 1 && visited[i][j] == false) {
                    count = 0;
                    dfs(i, j, num);
                    section.add(count);
                }
            }
        }

        System.out.println(section.size());
        Collections.sort(section);

        for (int number : section) {
            System.out.println(number);
        }
    }

    private static void dfs(int y, int x, int num) {
        if (visited[y][x] == true) {
            return;
        }

        visited[y][x] = true;
        count++;

        if (x-1 > -1 && matrix[y][x - 1] == 1) {
            dfs(y, x - 1, num);
        }

        if (y-1 > -1 && matrix[y - 1][x] == 1) {
            dfs(y - 1, x, num);
        }

        if (x+1 < num && matrix[y][x + 1] == 1) {
            dfs(y, x + 1, num);
        }

        if (y+1 < num && matrix[y + 1][x] == 1) {
            dfs(y + 1, x, num);
        }
    }
}
