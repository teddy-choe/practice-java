package algorithm.max_modifier;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int [][] operatorRank = new int[6][3];

        createOperatorRank(operatorRank);

        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        // 모든 조합을 loop한다
        for (int i=0; i<6; i++) {

            ArrayList<Character> digitList = new ArrayList<>();

            for (int j=0; j<expression.length(); j++) {
                char currentChar = expression.charAt(j);

                if (currentChar >= 48 && currentChar <= 57) {
                    digitList.add(currentChar);
                } else {
                    //TODO: 숫자 전환이 되는지 확인이 필요함
                    int num = Integer.valueOf(String.valueOf(digitList));
                    digitList.clear();
                }
            }
        }
    }

    private static void createOperatorRank(int[][] operatorRank) {
        operatorRank[0][0] = 0;
        operatorRank[0][1] = 1;
        operatorRank[0][2] = 2;

        operatorRank[1][0] = 0;
        operatorRank[1][1] = 2;
        operatorRank[1][2] = 1;

        operatorRank[2][0] = 1;
        operatorRank[2][1] = 0;
        operatorRank[2][2] = 2;

        operatorRank[3][0] = 2;
        operatorRank[3][1] = 0;
        operatorRank[3][2] = 1;

        operatorRank[4][0] = 1;
        operatorRank[4][1] = 2;
        operatorRank[4][2] = 0;

        operatorRank[5][0] = 2;
        operatorRank[5][1] = 1;
        operatorRank[5][2] = 0;
    }
}
