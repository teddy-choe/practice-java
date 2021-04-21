package algorithm.test_di;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.getTestInstructor());
    }

    public long getTestInstructor() {
        long result = 0;

        Scanner scanner = new Scanner(System.in);

        int spaceNum = scanner.nextInt();
        ArrayList<Integer> testerPerSpace = new ArrayList<>();
        ArrayList<Integer> instructorPerSpace = new ArrayList<>();

        for (int i=0; i<spaceNum; i++) {
            int n = scanner.nextInt();
            testerPerSpace.add(n);
        }

        int infoMain = scanner.nextInt();
        int infoSub = scanner.nextInt();

        for (int tester: testerPerSpace) {
            int num = tester - infoMain;

            if (num <= 0) {
                instructorPerSpace.add(1);
                continue;
            }

            if (num % infoSub != 0) {
                instructorPerSpace.add((num / infoSub) + 2);
            } else {
                instructorPerSpace.add((num / infoSub) + 1);
            }
        }

        for (int instructor: instructorPerSpace) {
            result += instructor;
        }

        return result;
    }
}
