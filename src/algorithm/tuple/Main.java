package algorithm.tuple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

    public int[] solution(String s) {
        int[] answer;

        ArrayList<ArrayList<Integer>> tupleList = new ArrayList<>();
        ArrayList<Integer> resultTuple = new ArrayList<>();

        String[] splitString = s.substring(1, s.length() - 1)
                .replaceAll("[{]", " ")
                .replaceAll("[}]", " ")
                .trim()
                .split(" ,");


        for (String string : splitString) {
            ArrayList<Integer> tempList = new ArrayList<>();

            String[] temp2 = string.split(",");

            for (String str : temp2) {
                tempList.add(Integer.valueOf(str.trim()));
            }

            tupleList.add(tempList);
        }

        Collections.sort(tupleList, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        for (ArrayList<Integer> list : tupleList) {
            for (int num : list) {
                if (!resultTuple.contains(num)) {
                    resultTuple.add(num);
                }
            }
        }

        int i = 0;
        answer = new int[resultTuple.size()];

        for (int n : resultTuple) {
            answer[i] = n;
            i++;
        }

        return answer;
    }
}
