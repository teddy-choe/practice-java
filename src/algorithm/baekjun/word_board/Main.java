package algorithm.baekjun.word_board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        board = new String[n][m];

        for (int i=0; i<n; i++) {
            String[] strings = bufferedReader.readLine().split("");
            for (int j=0; j<m; j++) {
                board[i][j] = strings[j];
            }
        }

        String target = bufferedReader.readLine();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j].equals(String.valueOf(target.charAt(0)))) {
                    search(i, j, 1, board[i][j], target, k);
                }
            }
        }

        System.out.println(count);
    }

    // 왜 메모리 초과가 발생할까?
    // 함수 시작할때는 두번째 문자부터 추적, index 1 대입
    static void search(int row, int col, int index, String ans, String target, int k) {
        if (ans.equals(target)) {
            count++;
            return;
        }

        if (index >= target.length()) {
            return;
        }

        for (int i=0; i<4; i++) {
            for (int j=1; j<=k; j++) {
                int toRow = row + dy[i] * j;
                int toCol = col + dx[i] * j;

                if (toRow < 0 || toRow >= board.length || toCol < 0 || toCol >= board[0].length) {
                    continue;
                }

                if (board[toRow][toCol].equals(String.valueOf(target.charAt(index)))) {
                    search(toRow, toCol, index+1, ans + board[toRow][toCol], target, k);
                }
            }
        }
    }
}
