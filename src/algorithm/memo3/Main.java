package algorithm.memo3;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[][] array = {{1, 10, 20, 6}, {2, 12, 20, 8}, {3, 20, 30, 2}, {4, 25, 40, 10}};
        main.solution(30, array);
    }

    public int[] solution(int endingTime, int[][] jobs) {
        int[] answer = {};
        int index = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for(int[] job: jobs) {
            int workingTime = job[1] + job[3];

            if(workingTime >= job[2]) {
                continue;
            }

            if(workingTime > endingTime) {
                continue;
            }

            result.add(job[0]);
        }

        answer = new int[result.size()];

        for (int n : result) {
            answer[index++] = n;
        }

        return answer;
    }
}