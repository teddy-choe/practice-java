package algorithm.duplication;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        String string = "abcdaaeddfg";

        for (char token : string.toCharArray()) {
            if (hashMap.containsKey(token)) {
                hashMap.put(token, hashMap.get(token) + 1);
            } else {
                hashMap.put(token, 1);
            }
        }

        Iterator<Character> keys = hashMap.keySet().iterator();
        boolean isDuplicated = false;

        while (keys.hasNext()) {
            char key = keys.next();
            if (hashMap.get(key) != 1) {
                isDuplicated = true;
                break;
            }
        }

        if (isDuplicated) {
            System.out.println("중복있음");
        } else {
            System.out.println("중복없음");
        }
    }
}
