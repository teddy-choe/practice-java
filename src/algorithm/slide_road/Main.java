package algorithm.slide_road;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int[][] map = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        for (int i=0; i<n; i++) {
            ArrayList<Integer> colList = new ArrayList<>();
            ArrayList<Integer> rowList = new ArrayList<>();
            int[] cols = new int[n];
            int[] rows = new int[n];

            for (int j=0; j<n; j++) {
                colList.add(map[i][j]);
                rowList.add(map[j][i]);
            }

            for (int z=0; z<colList.size(); z++) {
                cols[z] = colList.get(z);
                rows[z] = rowList.get(z);
            }

            if (checkRoad(cols, l)) {
                count++;
            }

            if (checkRoad(rows, l)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean checkRoad(int[] road, int l) {
        boolean isSameHeight = true;

        for (int i=0; i<road.length-1; i++) {
            if (road[i] != road[i+1]) {
                isSameHeight = false;
                break;
            }
        }

        if (isSameHeight) {
            return true;
        }

        boolean[] already = new boolean[road.length];

        for (int i=0; i<road.length-1; i++) {
            if (road[i] != road[i+1]) {
                if (Math.abs(road[i] - road[i+1]) != 1) {
                    return false;
                }

                int count = 0;

                if (road[i] > road[i+1]) {
                    int height = road[i+1];

                    while (count < l) {
                        if ((i+1+count) >= road.length || road[i+1+count] != height || already[i+1+count]) {
                            return false;
                        }

                        already[i+1+count] = true;
                        count++;
                    }
                } else {
                    int height = road[i];

                    while (count < l) {
                        if ((i-count) < 0 || road[i-count] != height || already[i-count]) {
                            return false;
                        }

                        already[i-count] = true;
                        count++;
                    }
                }
            }
        }
        return true;
    }
}
