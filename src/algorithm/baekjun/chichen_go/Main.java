/*
 * 백준 15686번 치킨 배달
 * https://www.acmicpc.net/problem/15686
 */

package algorithm.baekjun.chichen_go;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 치킨집과 집을 일차원 구조로 계산하기 위함
        ArrayList<int[]> homeList = new ArrayList<>();
        ArrayList<int[]> chickenList = new ArrayList<>();

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int num = scanner.nextInt();

                if (num == 1) {
                    homeList.add(new int[]{i, j});
                } else if (num == 2) {
                    chickenList.add(new int[]{i, j});
                }
            }
        }

        // m개의 치킨집을 선정한다
        combination(m, 0, 0, homeList, chickenList, new ArrayList<>());

        System.out.println(min);
    }

    static void combination(int m, int depth, int index, ArrayList<int[]> homeList, ArrayList<int[]> chickenList, ArrayList<int[]> chooseList) {
        if (depth == m) {
            calcurateChickenDistance(homeList, chooseList);
        }

        if (index == chickenList.size()) {
            return;
        }

        ArrayList<int[]> temp = (ArrayList<int[]>) chooseList.clone();
        temp.add(chickenList.get(index));
        combination(m, depth+1, index+1, homeList, chickenList, temp);
        combination(m, depth, index+1, homeList, chickenList, chooseList);
    }

    private static void calcurateChickenDistance(ArrayList<int[]> homeList, ArrayList<int[]> chooseList) {
        int minTemp = 0;

        // 각 집마다 치킨 거리를 구해서 해당 조합이 최소 치킨 거리인지 판별한다
        for (int[] home : homeList) {
            int homeDis = Integer.MAX_VALUE;

            for (int[] choose: chooseList) {
                int dis = Math.abs(home[0] - choose[0]) + Math.abs(home[1] - choose[1]);
                homeDis = Math.min(homeDis, dis);
            }

            minTemp += homeDis;
        }

        min = Math.min(min, minTemp);
    }
}
