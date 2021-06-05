package algorithm.ladder;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class Line {
        int height;
        int start;
        int end;

        public Line(int height, int start, int end) {
            this.height = height;
            this.start = start;
            this.end = end;
        }
    }
    static int count = -1;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int h = scanner.nextInt();

        ArrayList<Line> lines = new ArrayList<>();

        for (int i=0; i<m; i++) {
            int height = scanner.nextInt();
            int start = scanner.nextInt();
            lines.add(new Line(height, start, start+1));
        }

        if (isCorrectLadder(lines, n, h)) {
            System.out.println(0);
            return;
        }

        for (int i=1; i<=3; i++) {
            visited = new boolean[h+1][n+1];
            putLadder(lines, i, 0, n, h);
        }

        if (count > 3) {
            System.out.println(-1);
        }

        System.out.println(count);
    }

    public static void putLadder(ArrayList<Line> lines, int max, int index, int n, int h) {
        if (index == max) {
            if (isCorrectLadder(lines, n, h)) {
                count = max;
            }

            return;
        }

        for (int i=1; i<=h; i++) {
            for (int j=1; j<n; j++) {
                boolean isPossible = true;

                for (Line line : lines) {
                    if (line.height == i) {
                        if (line.start == j || line.end == j+1 || line.end == j || line.start == j+1) {
                            isPossible = false;
                        }
                    }
                }

                if (isPossible && !visited[i][j]) {
                    ArrayList<Line> putLines = (ArrayList<Line>) lines.clone();
                    putLines.add(new Line(i, j, j+1));
                    visited[i][j] = true;
                    putLadder(putLines, max, index+1, n, h);
                    putLadder(lines, max, index, n, h);
                    visited[i][j] = false;
                }
            }
        }
    }

    public static boolean isCorrectLadder(ArrayList<Line> lines, int n, int h) {
        for (int i=1; i<=n; i++) {
            int curLadder = i;

            for (int j=1; j<=h; j++) {
                for (Line line : lines) {
                    if (line.height == j) {
                        if (line.start == curLadder) {
                            curLadder = line.end;
                        } else if (line.end == curLadder) {
                            curLadder = line.start;
                        }
                    }
                }
            }

            if (curLadder != i) {
                return false;
            }
        }

        return true;
    }
}
