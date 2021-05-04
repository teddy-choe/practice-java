package algorithm.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

class Main {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Main main = new Main();

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = main.spiralOrder(matrix);

        for (int num : list) {
            System.out.println(num);
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        boolean isValidToMove = true;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int curRow = 0;
        int curCol = 0;
        int dir = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        visited[0][0] = true;

        while(isValidToMove) {
            int nextRow = curRow + dy[dir];
            int nextCol = curCol + dx[dir];

            if(count == 4) {
                isValidToMove = false;
                break;
            }

            if (nextRow < 0 || nextCol < 0 || nextRow >= matrix.length || nextCol >= matrix[0].length
                    || visited[nextRow][nextCol] == true) {
                // change direction
                dir = (dir + 1) % 4;
                count++;
            } else {
                curRow = nextRow;
                curCol = nextCol;
                visited[curRow][curCol] = true;
                list.add(matrix[curRow][curCol]);
                count = 0;
            }
        }

        return list;
    }
}
