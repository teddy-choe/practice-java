package algorithm.baekjun.go_school;

public class Main {
    static long[][] dp;

    public static void main(String[] args) {
        Main main = new Main();

        int m = 100;
        int n = 100;
        int[][] puddles = new int[][]{{1,2}};

        int answer = main.solution(m,n,puddles);
        System.out.println(answer);
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        dp = new long[n][m];

        long result = move(n-1, m-1, puddles);
        result = result % 1000000007;

        answer = (int) result;

        return answer;
    }

    public long move(int y, int x, int[][] puddles) {
        if (x == 0 && y == 0) {
            return 1;
        }

        if (x<0 || y<0) {
            return 0;
        }

        for (int[] puddle: puddles) {
            if (x == puddle[0] - 1 && y == puddle[1] - 1) {
                return 0;
            }
        }

        if (dp[y][x] != 0) {
            return dp[y][x];
        } else {
            return dp[y][x] = move(y-1, x, puddles) + move(y, x-1, puddles);
        }
    }
}
