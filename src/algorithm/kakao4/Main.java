package algorithm.kakao4;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        System.out.println(main.solution(board));
    }

    public int solution(int[][] board) {
        int answer = 0;

        int[][] left = new int[board.length][board[0].length];
        int[][] top = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    left[i][j] = -1;
                    top[i][j] = -1;
                    continue;
                }

                if (i == 0 && j == 0) {
                    left[i][j] = 100;
                    top[i][j] = 100;
                    continue;
                }

                if (i == 0) {
                    left[i][j] = left[i][j - 1] + 100;
                    top[i][j] = -1;
                    continue;
                }

                if (j == 0) {
                    top[i][j] = top[i - 1][j] + 100;
                    left[i][j] = -1;
                    continue;
                }

                if (top[i - 1][j] == -1) {
                    top[i][j] = left[i - 1][j] + 500;
                } else {
                    top[i][j] = Math.min((top[i - 1][j] + 100), left[i - 1][j] + 500);
                }

                if (left[i][j - 1] == -1) {
                    left[i][j] = top[i][j - 1] + 500;
                } else {
                    left[i][j] = Math.min((top[i][j - 1] + 500), left[i][j - 1] + 100);
                }
            }
        }

        answer = Math.min(top[board.length - 1][board.length - 1], left[board.length - 1][board.length - 1]);

        return answer;
    }
}
