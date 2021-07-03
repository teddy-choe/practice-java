package algorithm.programmers.walkheaven;

class Main {
    int MOD = 20170805;
    int[][] street;

    public static void main(String[] args) {
        Main main = new Main();

        int[][] cityMap = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};

        System.out.println(main.solution(3,6, cityMap));
    }

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        street = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                street[i][j] = -1;
            }
        }

        dfs(cityMap, m-1, n-1, -1);

        return answer = street[m-1][n-1];
    }

    public int dfs(int[][] cityMap, int row, int col, int direction) {
        if(row < 0 || col < 0) {
            return 0;
        }

        if(row == 0 && col == 0) {
            return 1;
        }

        if (street[row][col] != -1) {
            return street[row][col];
        }

        if (cityMap[row][col] == 1) {
            return street[row][col] = 0;
        }

        if (cityMap[row][col] == 2 && direction == 1) {
            return street[row][col] = dfs(cityMap, row-1, col, 1) % MOD;
        }

        if (cityMap[row][col] == 2 && direction == 0) {
            return street[row][col] = dfs(cityMap, row, col-1, 0) % MOD;
        }

        return street[row][col] = (dfs(cityMap, row-1, col, 1) + dfs(cityMap, row, col-1, 0)) % MOD;
    }
}
