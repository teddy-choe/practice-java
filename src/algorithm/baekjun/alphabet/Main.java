package algorithm.baekjun.alphabet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    private static char[][] maps;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        maps = new char[r][c];

        for (int i=0; i<r; i++) {
            String str = bufferedReader.readLine();
            for (int j=0; j<c; j++) {
                maps[i][j] = str.charAt(j);
            }
        }

        boolean[] visited = new boolean[26];
        backTracking(0,0, visited, 1);
        System.out.println(max);
    }

    public static void backTracking(int row, int col, boolean[] visited, int count) {
        char cur = maps[row][col];
        visited[cur - 'A'] = true;

        for (int i=0; i<4; i++) {
            int ny = row + dy[i];
            int nx = col + dx[i];

            if (ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length) {
                continue;
            }

            int next = maps[ny][nx] - 'A';

            if (!visited[next]) {
                backTracking(ny, nx, visited, count+1);
            }
        }

        visited[cur - 'A'] = false;
        if (count > max) {
            max = count;
        }
    }
}
