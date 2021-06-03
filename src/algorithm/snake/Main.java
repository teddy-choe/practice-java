package algorithm.snake;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int dir = 0;
    public static int[][] dirList;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mapNum = sc.nextInt();

        int[][] map = new int[mapNum+2][mapNum+2];

        for (int i=0; i<map.length; i++) {
            map[i][0] = -2;
            map[i][map.length-1] = -2;
        }

        for (int i=0; i<map.length; i++) {
            map[0][i] = -2;
            map[map.length-1][i] = -2;
        }

        int apple = sc.nextInt();

        for (int i=0; i<apple; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            map[row][col] = 1;
        }

        //dir
        int dirNum = sc.nextInt();
        dirList = new int[dirNum][2];
        for (int i=0; i<dirNum; i++) {
            dirList[i][0] = sc.nextInt();
            String temp = String.valueOf(sc.next());
            if (temp.equals("D")) {
                dirList[i][1] = 0;
            } else {
                dirList[i][1] = 1;
            }
        }

        System.out.println(move(map));
    }

    public static int move(int[][] map) {
        Deque<Point> deque = new LinkedList<>();
        int count = 0;

        deque.add(new Point(1,1));

        while (!deque.isEmpty()) {
            Point temp = new Point((deque.peekLast().row + dy[dir]), (deque.peekLast().col + dx[dir]));
            count++;

            if (map[temp.row][temp.col] == -1 || map[temp.row][temp.col] == -2) {
                // 해당 영역 뱀 몸통인 경우 또는 벽
                return count;
            }

            if (map[temp.row][temp.col] == 0) {
                // 영역이 사과가 아닌 경우
                Point toDelete = deque.poll();
                map[toDelete.row][toDelete.col] = 0;
            }
            map[temp.row][temp.col] = -1;
            deque.add(temp);

            for (int[] dirElement : dirList) {
                if (dirElement[0] == count) {
                    if (dirElement[1] == 0) {
                        dir = (dir + 1) % 4;
                    } else {
                        dir = (dir - 1) % 4;
                    }
                }
            }
        }
        return count;
    }
}
