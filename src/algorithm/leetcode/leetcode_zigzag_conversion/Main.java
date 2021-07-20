package algorithm.leetcode.leetcode_zigzag_conversion;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String s = "PAYPALISHIRING";
        int numRows = 4;
        main.convert(s, numRows);
    }

    public String convert(String s, int numRows) {
        String answer = "";

        if(numRows == 1) {
            return s;
        }

        char[][] matrix = new char[numRows][1000];

        for (char[] a: matrix) {
            Arrays.fill(a, '!');
        }

        int index = 0;
        int x = 0;
        int y = 0;
        boolean flag = false;

        while(index < s.length()) {
            // if flag is false, write to vertically
            if (!flag) {
                matrix[y][x] = s.charAt(index++);

                if (y == numRows-1) {
                    flag = true;
                    y--;
                    x++;
                } else {
                    y++;
                }
            } else {
                matrix[y][x] = s.charAt(index++);

                if (y == 0) {
                    flag = false;
                    y++;
                } else {
                    y--;
                    x++;
                }
            }
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j]!='!') {
                    stringBuffer.append(matrix[i][j]);
                }
            }
        }

        answer = stringBuffer.toString();

        return answer;
    }
}
