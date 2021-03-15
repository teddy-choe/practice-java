package algorithm.allyadapter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean isAdapter[];
    private static ArrayList<ArrayList<Integer>> socialTree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleNum = scanner.nextInt();

        isAdapter = new boolean[peopleNum];
        socialTree = new ArrayList<ArrayList<Integer>>(peopleNum);

        for (int i=0; i<peopleNum; i++) {
            socialTree.add(new ArrayList<>());
        }

        for (int i=0; i<peopleNum-1; i++) {
            int firstMan = Integer.valueOf(scanner.next()) - 1;
            int secondMan = Integer.valueOf(scanner.next()) - 1;

            socialTree.get(firstMan).add(secondMan);
            socialTree.get(secondMan).add(firstMan);
        }

        for (int i=peopleNum-1; i>=0; i--) {
            if (isAdapter[i]) {
                continue;
            }

            for (int friendIndex : socialTree.get(i)) {
                if (!isAdapter[friendIndex]) {
                    isAdapter[friendIndex] = true;
                }
            }
        }

        int count = 0;
        for (int i=0; i<isAdapter.length; i++) {
            if (isAdapter[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
