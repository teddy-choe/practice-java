package algorithm.programmers.recommend_id;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }

    public String solution(String new_id) {
        String answer = "";

        ArrayList<Character> temp = new ArrayList<>();
        for (int i=0; i<new_id.length(); i++) {
            if ((int)new_id.charAt(i) >= 65 && (int)new_id.charAt(i) <= 90) {
                char letter = (char)((int)new_id.charAt(i) + 32);
                temp.add(letter);
            } else {
                temp.add(new_id.charAt(i));
            }
        }
        new_id = temp.toString();

        new_id.replaceAll("[~!@#$%^&*()=+[{]}:?,<>/]", "");


        return answer;
    }
}
