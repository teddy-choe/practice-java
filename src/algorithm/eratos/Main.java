package algorithm.eratos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        boolean[] visited = new boolean[n+1];
        ArrayList<Integer> eratosList = new ArrayList<>();
        visited[0] = true;
        visited[1] = true; // 0, 1 non

        for (int i=2; i<=n; i++) {
            if (!visited[i]) {
                int curNum = i;
                int idx = 1;
                while (curNum <= n) {
                    int mulNum = curNum * idx;
                    idx++;

                    if (mulNum > n) {
                        break;
                    }

                    if (visited[mulNum]) continue;

                    visited[mulNum] = true;
                    eratosList.add(mulNum);
                }
            }

            if (eratosList.size() >= k) {
                System.out.println(eratosList.get(k-1));
                return;
            }
        }
    }
}
