package algorithm.baekjun.room_number;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxNum = 0;

        String s = scanner.nextLine();
        char[] chars = s.replace("9", "6").toCharArray();

        for (char c : chars) {
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        for (char ch : hashMap.keySet()) {
            int cur = hashMap.get(ch);

            if (ch == '6') {
                if (cur % 2 == 0) {
                    cur = cur / 2;
                } else {
                    cur = cur / 2 + 1;
                }
            }

            maxNum = Math.max(maxNum, cur);
        }

        System.out.println(maxNum);
    }
}
