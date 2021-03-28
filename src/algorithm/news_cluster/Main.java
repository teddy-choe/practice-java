package algorithm.news_cluster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String str1 = "abcdeabcde";
        String str2 = "#@#@";

        int result = main.solution(str1, str2);

        System.out.println(result);
    }

    public int solution(String str1, String str2) {
        int answer = 0;

        ArrayList<String> temp1 = new ArrayList<>();
        ArrayList<String> temp2 = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i=0; i<str1.length()-1; i++) {
            if (str1.charAt(i) >= 97 && str1.charAt(i) < 123
                    && str1.charAt(i+1) >= 97 && str1.charAt(i+1) < 123
            ) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str1.charAt(i));
                stringBuilder.append(str1.charAt(i+1));
                temp1.add(stringBuilder.toString());
            }
        }

        for (int i=0; i<str2.length()-1; i++) {
            if (str2.charAt(i) >= 97 && str2.charAt(i) < 123
                    && str2.charAt(i+1) >= 97 && str2.charAt(i+1) < 123
            ) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2.charAt(i));
                stringBuilder.append(str2.charAt(i+1));
                temp2.add(stringBuilder.toString());
            }
        }

        HashMap<String, Integer> hashMap1 = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();

        for (String str : temp1) {
            if (hashMap1.containsKey(str)) {
                hashMap1.put(str, hashMap1.get(str) + 1);
            } else {
                hashMap1.put(str, 1);
            }
        }

        for (String str : temp2) {
            if (hashMap2.containsKey(str)) {
                hashMap2.put(str, hashMap2.get(str) + 1);
            } else {
                hashMap2.put(str, 1);
            }
        }

        int unite = 0;
        int interSection = 0;

        // iterator가 그냥 hashmap 루프보다 뭐가 더 낫지?
        Iterator<String> iterator = hashMap1.keySet().iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();

            if (hashMap2.containsKey(str)) {
                interSection += Math.min(hashMap1.get(str), hashMap2.get(str));
                unite += Math.max(hashMap1.get(str), hashMap2.get(str));

                hashMap2.remove(str);
            } else {
                unite += hashMap1.get(str);
            }
        }

        Iterator<String> iterator2 = hashMap2.keySet().iterator();
        while (iterator2.hasNext()) {
            String str = iterator2.next();

            unite += hashMap2.get(str);
        }

        if (unite == 0) {
            return 0;
        }

        double j = interSection / (double)unite;
        answer = (int) (j * 65536);

        return answer;
    }
}
