package algorithm.observe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Camera> cctvs;
    static int min = 64;

    public static class Camera {
        int row;
        int col;
        int type;

        public Camera(int row, int col, int type) {
            this.row = row;
            this.col = col;
            this.type = type;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] maps = new int[row][col];
        cctvs = new ArrayList<>();

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                maps[i][j] = scanner.nextInt();

                if (maps[i][j] == 1 || maps[i][j] == 2 || maps[i][j] == 3 || maps[i][j] == 4 || maps[i][j] == 5) {
                    cctvs.add(new Camera(i,j,maps[i][j]));
                }
            }
        }

        dfs(maps, 0);

        System.out.println(min);
    }

    public static void dfs(int[][] maps, int index) {
        if (index == cctvs.size()) {
            int count = 0;

            for (int i=0; i<maps.length; i++) {
                for (int j=0; j<maps[0].length; j++) {
                    if (maps[i][j] == 0) {
                        count++;
                    }
                }
            }

            if (count < min) {
                min = count;
                return;
            }
        }

        Camera cctv = cctvs.get(index);

        switch (cctv.type) {
            case 1:
                for (int i=0; i<4; i++) {
                    int[][] tempMaps = maps.clone();
                    observe(tempMaps, i, cctv);
                    dfs(tempMaps, index+1);
                }
                break;

            case 2:
                for (int i=0; i<4; i++) {
                    int[][] tempMaps = maps.clone();
                    observe(tempMaps, i, cctv);
                    observe(tempMaps, (i+2)%4, cctv);
                    dfs(tempMaps, index+1);
                }
                break;

            case 3:
                for (int i=0; i<4; i++) {
                    int[][] tempMaps = maps.clone();
                    observe(tempMaps, i, cctv);
                    observe(tempMaps, (i+1)%4, cctv);
                    dfs(tempMaps, index+1);
                }
                break;

            case 4:
                for (int i=0; i<4; i++) {
                    int[][] tempMaps = maps.clone();
                    observe(tempMaps, i, cctv);
                    observe(tempMaps, (i+1)%4, cctv);
                    observe(tempMaps, (i+2)%4, cctv);
                    dfs(tempMaps, index+1);
                }
                break;

            case 5:
                for (int i=0; i<4; i++) {
                    int[][] tempMaps = maps.clone();
                    observe(tempMaps, i, cctv);
                    observe(tempMaps, (i+1)%4, cctv);
                    observe(tempMaps, (i+2)%4, cctv);
                    observe(tempMaps, (i+3)%4, cctv);
                    dfs(tempMaps, index+1);
                }
                break;

            default:
                break;
        }
    }

    public static int[][] observe(int[][] maps, int direction, Camera cctv) {
        int row = cctv.row;
        int col = cctv.col;

        switch (direction) {
            case 0:
                while (true) {
                    int nextRow = row - 1;
                    if (nextRow < 0 || maps[nextRow][col] == 6) {
                        break;
                    }

                    maps[nextRow][col] = 7;
                    row = nextRow;
                }
                break;
            case 1:
                while (true) {
                    int nextCol = col + 1;
                    if (nextCol > maps[0].length-1 || maps[row][nextCol] == 6) {
                        break;
                    }

                    maps[row][nextCol] = 7;
                    col = nextCol;
                }
                break;
            case 2:
                while (true) {
                    int nextRow = row + 1;
                    if (nextRow > maps.length-1 || maps[nextRow][col] == 6) {
                        break;
                    }

                    maps[nextRow][col] = 7;
                    row = nextRow;
                }
                break;
            case 3:
                while (true) {
                    int nextCol = col - 1;
                    if (nextCol < 0 || maps[row][nextCol] == 6) {
                        break;
                    }

                    maps[row][nextCol] = 7;
                    col = nextCol;
                }
                break;
            default:
                break;
        }

        return maps;
    }
}
