package algorithm.ground_ted;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[][] land = new int[][]{{1,1,1,1},{2,2,2,2},{1,1,1,1}};

        int result = main.solution(land);
        System.out.println(result);
    }

    int solution(int[][] land) {
        int answer = 0;
        int preIndex = -1;

        for (int i=0; i<land.length; i++) {
            int max = 0;
            int currentIndex = -1;
            for (int j=0; j<4; j++) {
                if (land[i][j] > max && j != preIndex) {
                    max = land[i][j];
                    currentIndex = j;
                }
            }
            answer += max;
            preIndex = currentIndex;
        }

        return answer;
    }
}
