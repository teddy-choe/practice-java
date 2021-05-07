package algorithm.kakao3;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String[] gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        int[] answer = main.solution(gems);

        for (int num : answer) {
            System.out.println(num);
        }
    }

    public int[] solution(String[] gems) {
        int[] answer = {};

        HashSet<String> hashSet = new HashSet<>();
        for (String gem : gems) {
            hashSet.add(gem);
        }

        int kindNum = hashSet.size();

        if(kindNum == 1) {
            return answer = new int[]{1,1};
        }

        hashSet.clear();
        int head = 0;
        int tail = gems.length - 1;

        while (true) {
            ArrayList<String> temp = new ArrayList<>();

            for(int i=head; i<=tail; i++) {
                temp.add(gems[i]);
            }

            for(String str : temp) {
                hashSet.add(str);
            }

            if(hashSet.size() == kindNum) {
                tail--;
                hashSet.clear();
                continue;
            } else {
                tail++;
                hashSet.clear();
                break;
            }
        }

        while (true) {
            ArrayList<String> temp = new ArrayList<>();

            for(int i=head; i<=tail; i++) {
                temp.add(gems[i]);
            }

            for(String str : temp) {
                hashSet.add(str);
            }

            if(hashSet.size() == kindNum) {
                head++;
                hashSet.clear();
                continue;
            } else {
                head--;
                hashSet.clear();
                break;
            }
        }

        answer = new int[]{head+1, tail+1};

        return answer;
    }
}
