package algorithm.bead_exit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Beads {
        int rx;
        int ry;
        int bx;
        int by;
        int count;
        boolean isRedSuccess;
        boolean isBlueSuccess;

        public Beads(int rx, int ry, int bx, int by, int count, boolean isRedSuccess, boolean isBlueSuccess) {

        }
    }

    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new char[n][m];
        int rx = 0;
        int ry = 0;
        int bx = 0;
        int by = 0;

        sc.nextLine();
        for (int i=0; i<n; i++) {
            String temp = sc.nextLine();
            for (int j=0; j<m; j++) {
                char c = temp.charAt(j);
                if (c == 'R') {
                    ry = i;
                    rx = j;
                }

                if (c == 'B') {
                    by = i;
                    bx = j;
                }

                map[i][j] = c;
            }
        }

        int dir;
        Queue<Beads> queue = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][m][n][m];
        queue.add(new Beads(rx, ry, bx, by, 0, false, false));

        while(true) {
            Beads cur = queue.poll();
            visited[cur.ry][cur.rx][cur.by][cur.bx] = true;

            if (cur.count == 10) {
                break;
            }

            for (int j=0; j<4; j++) {
                dir = j;
                Beads moved = move(dir, cur);

                if ((moved.isRedSuccess && moved.isBlueSuccess) || moved.isBlueSuccess) {
                    System.out.println(-1);
                    return;
                }

                if (moved.isRedSuccess) {
                    System.out.println(moved.count);
                    return;
                }

                if (!visited[moved.ry][moved.rx][moved.by][moved.bx]){
                    queue.add(moved);
                }
            }
        }

        System.out.println(-1);
    }

    public static Beads move(int dir, Beads cur) {
        int nRx = cur.rx;
        int nRy = cur.ry;
        int nBx = cur.bx;
        int nBy = cur.by;
        int count = cur.count;
        boolean isRedSuccess = cur.isRedSuccess;
        boolean isBlueSuccess = cur.isBlueSuccess;

        while (true) {
            if (nRx+dx[dir] < 0 || nRy+dy[dir] < 0 || nRx+dx[dir] >= map[0].length || nRy+dy[dir] >= map[0].length) {
                break;
            }

            nRx += dx[dir];
            nRy += dy[dir];

            if (map[nRy][nRx] == '#') {
                break;
            }

            if (map[nRy][nRx] == '0') {
                isRedSuccess = true;
                break;
            }
        }

        while (true) {
            if (nBx+dx[dir] < 0 || nBy+dy[dir] < 0 || nBx+dx[dir] >= map.length || nBy+dy[dir] >= map.length ) {
                break;
            }

            nBx += dx[dir];
            nBy += dy[dir];

            if (map[nBy][nBx] == '#') {
                break;
            }

            if (map[nBy][nBx] == '0') {
                isBlueSuccess = true;
                break;
            }
        }

        if ((nRx == nBx) && (nRy == nBy)) {
            int disRed = Math.abs(nRx - cur.rx) + Math.abs(nRy - cur.ry);
            int disBlue = Math.abs(nBx - cur.bx) + Math.abs(nBy - cur.by);

            if (disRed > disBlue) {
                nRx = nRx - dx[dir];
                nRy = nRy - dy[dir];
            } else {
                nBx = nBx - dx[dir];
                nBy = nBy - dy[dir];
            }
        }

        return new Beads(nRx, nRy, nBx, nBy, count+1, isRedSuccess, isBlueSuccess);
    }
}
