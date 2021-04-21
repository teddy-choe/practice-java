package algorithm.wordrace;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};

        int[] result = main.solution(5, words);

        for (int n : result) {
            System.out.println(n);
        }
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int userIdx = 0;
        int roofNum = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            int curUserIdx = i % n + 1;
            int curRoofNum = i / n + 1;

            if (i != 0 &&
                    words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)
                    || words[i].length() == 1
                    || hashMap.containsKey(words[i])) {
                userIdx = curUserIdx;
                roofNum = curRoofNum;

                break;
            }

            hashMap.put(words[i], 1);
        }

        answer[0] = userIdx;
        answer[1] = roofNum;

        return answer;
    }
}
