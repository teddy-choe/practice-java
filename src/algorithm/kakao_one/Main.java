package algorithm.kakao_one;

public class Main {
    private int leftX = 0;
    private int leftY = 3;
    private int rightX = 2;
    private int rightY = 3;
    int[][] keypad = {{1,2,3}, {4,5,6}, {7,8,9}, {-1,0,-2}};

    public static void main(String[] args) {
        Main main = new Main();

        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};

        System.out.println(main.solution(numbers, "left"));
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuffer resultBuffer = new StringBuffer();

        for (int i=0; i<numbers.length; i++) {
            resultBuffer.append(selectKeyPad(numbers[i], hand));
        }

        answer = resultBuffer.toString();
        return answer;
    }

    private String selectKeyPad(int toSelectNumber, String hand) {
        int tempX = 0;
        int tempY = 0;
        for (int i=0; i<4; i++) {
            for (int j=0; j<3; j++) {
                if (keypad[i][j] == toSelectNumber) {
                    tempX = j;
                    tempY = i;
                }
            }
        }

        if (toSelectNumber == 1 || toSelectNumber == 4 || toSelectNumber == 7) {
            leftX = tempX;
            leftY = tempY;
            return "L";
        } else if (toSelectNumber == 3 || toSelectNumber == 6 || toSelectNumber == 9) {
            rightX = tempX;
            rightY = tempY;
            return "R";
        } else {
            int leftDistance = Math.abs(tempX - leftX) + Math.abs(tempY - leftY);
            int rightDistance = Math.abs(tempX - rightX) + Math.abs(tempY - rightY);

            if (leftDistance == rightDistance) {
                if (hand.equals("left")) {
                    leftX = tempX;
                    leftY = tempY;
                    return "L";
                } else {
                    rightX = tempX;
                    rightY = tempY;
                    return "R";
                }
            } else {
                if (leftDistance < rightDistance) {
                    leftX = tempX;
                    leftY = tempY;
                    return "L";
                } else {
                    rightX = tempX;
                    rightY = tempY;
                    return "R";
                }
            }
        }
    }
}
