package algorithm.game_2048;

import java.util.Scanner;

public class Main {
    private int max = 0;

    public static void main(String[] args) {
        Main main = new Main();

        main.solution();
    }

    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] maps = new int[n+2][n+2];

        for (int i=0; i<maps.length; i++) {
            for (int j=0; j<maps.length; j++) {
                if (i == 0 || j == 0 || i == maps.length-1 || j == maps.length-1) {
                    // wall
                    maps[i][j] = -1;
                } else {
                    maps[i][j] = scanner.nextInt();
                }
            }
        }

        dfs(maps, 0);

        System.out.println(max);
    }

    private void dfs(int[][] maps, int index) {
        if (index == 5) {
            for (int i=1; i<maps.length-1; i++) {
                for (int j=1; j<maps.length-1; j++) {
                    if (maps[i][j] > max) {
                        max = maps[i][j];
                    }
                }
            }

            return;
        }

        for (int i=0; i<4; i++) {
            int[][] moveMaps = maps.clone();
            move(moveMaps, i);
            dfs(moveMaps, index+1);
        }
    }

    private int[][] move(int[][] maps, int dir) {
        switch (dir) {
            case 0:
                // up
                for (int row=1; row<maps.length-1; row++) {
                    for (int col=1; col<maps.length-1; col++) {
                        if (maps[row][col] != 0 && maps[row][col] != -1) {
                            int curRow = row;
                            int curCol = col;

                            while(true) {
                                int nextRow = curRow - 1;

                                if (maps[nextRow][col] != 0) {
                                    if (maps[nextRow][col] == -1) {
                                        break;
                                    }

                                    if (maps[nextRow][col] == maps[curRow][col]) {
                                        maps[nextRow][col] = maps[nextRow][col] * 2;
                                        maps[row][col] = 0;
                                    }

                                    break;
                                } else {
                                    // empty
                                    maps[nextRow][col] = maps[row][col];
                                    maps[row][col] = 0;

                                    curRow = nextRow;
                                }
                            }
                        }
                    }
                }
                break;

            case 1:
                // right
                for (int col=maps.length-2; col>0; col--) {
                    for (int row=1; row<maps.length-1; row++) {
                        if (maps[row][col] != 0 && maps[row][col] != -1) {
                            int curRow = row;
                            int curCol = col;

                            while(true) {
                                int nextCol = curCol + 1;

                                if (maps[curRow][nextCol] != 0) {
                                    if (maps[curRow][nextCol] == -1) {
                                        break;
                                    }

                                    if (maps[curRow][nextCol] == maps[curRow][curCol]) {
                                        maps[curRow][nextCol] = maps[curRow][nextCol] * 2;
                                        maps[row][col] = 0;
                                    }

                                    break;
                                } else {
                                    // empty
                                    maps[curRow][nextCol] = maps[row][col];
                                    maps[row][col] = 0;

                                    curCol = nextCol;
                                }
                            }
                        }
                    }
                }

                break;

            case 2:
                //down
                for (int row=maps.length-2; row>0; row--) {
                    for (int col=1; col<maps.length-1; col++) {
                        if (maps[row][col] != 0 && maps[row][col] != -1) {
                            int curRow = row;
                            int curCol = col;

                            while(true) {
                                int nextRow = curRow + 1;

                                if (maps[nextRow][col] != 0) {
                                    if (maps[nextRow][col] == -1) {
                                        break;
                                    }

                                    if (maps[nextRow][col] == maps[curRow][col]) {
                                        maps[nextRow][col] = maps[nextRow][col] * 2;
                                        maps[row][col] = 0;
                                    }

                                    break;
                                } else {
                                    // empty
                                    maps[nextRow][col] = maps[row][col];
                                    maps[row][col] = 0;

                                    curRow = nextRow;
                                }
                            }
                        }
                    }
                }

                break;

            case 3:
                // left

                for (int col=1; col<maps.length-1; col++) {
                    for (int row=1; row<maps.length-1; row++) {
                        if (maps[row][col] != 0 && maps[row][col] != -1) {
                            int curRow = row;
                            int curCol = col;

                            while(true) {
                                int nextCol = curCol - 1;

                                if (maps[curRow][nextCol] != 0) {
                                    if (maps[curRow][nextCol] == -1) {
                                        break;
                                    }

                                    if (maps[curRow][nextCol] == maps[curRow][curCol]) {
                                        maps[curRow][nextCol] = maps[curRow][nextCol] * 2;
                                        maps[row][col] = 0;
                                    }

                                    break;
                                } else {
                                    // empty
                                    maps[curRow][nextCol] = maps[row][col];
                                    maps[row][col] = 0;

                                    curCol = nextCol;
                                }
                            }
                        }
                    }
                }

                break;
        }

        return maps;
    }
}
