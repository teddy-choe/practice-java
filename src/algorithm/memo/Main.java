package algorithm.memo;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Main main = new Main();


        System.out.println(main.solution("1234567899"));
    }

    public int solution(String inputString) {
        int answer = 0;

        for(int i=1; i<1000; i++) {
            String outputString = "";
            for(int j=1; j<i; j++) {
                outputString += String.valueOf(j);
            }

            int inputIdx = 0;
            for(int w=0; w<outputString.length(); w++) {
                if(inputIdx == inputString.length()) {
                    return i-1;
                }
                char compareStr = inputString.charAt(inputIdx);

                if(compareStr == outputString.charAt(w)) {
                    inputIdx++;
                }
            }

            if(inputIdx == inputString.length()) {
                return i-1;
            }
        }

        return answer;
    }
}
