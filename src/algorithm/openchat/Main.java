package algorithm.openchat;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String[] record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = main.solution(record);

        for (String str: result) {
            System.out.println(str);
        }
    }

    class Word {
        String uid;
        String nickname;
        int state;

        public Word(String uid, String nickname, int state) {
            this.uid = uid;
            this.nickname = nickname;
            this.state = state;
        }
    }

    private ArrayList<Word> words;

    public String[] solution(String[] record) {
        String[] answer;
        words = new ArrayList<>();

        for (String rec : record) {
            StringTokenizer stringTokenizer = new StringTokenizer(rec, " ");
            String state = stringTokenizer.nextToken();

            if (state.equals("Enter")) {
                String uid = stringTokenizer.nextToken();
                String nickname = stringTokenizer.nextToken();
                words.add(new Word(uid, nickname, 0));

                for (Word word : words) {
                    if (word.uid.equals(uid)) {
                        word.nickname = nickname;
                    }
                }
            } else if (state.equals("Leave")) {
                String uid = stringTokenizer.nextToken();

                for (Word word : words) {
                    if (word.uid.equals(uid)) {
                        words.add(new Word(uid, word.nickname, 1));
                        break;
                    }
                }
            } else {
                String uid = stringTokenizer.nextToken();
                String nickname = stringTokenizer.nextToken();

                for (Word word : words) {
                    if (word.uid.equals(uid)) {
                        word.nickname = nickname;
                        break;
                    }
                }
            }
        }

        answer = new String[words.size()];
        int index = 0;

        for (Word word : words) {
            String temp = "";
            if (word.state == 0) {
                temp = word.nickname + "님이 들어왔습니다.";
            } else {
                temp = word.nickname + "님이 나갔습니다.";
            }
            answer[index++] = temp;
        }


        return answer;
    }

}
