package algorithm.palindrome;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<Character, Integer> hashMap = new HashMap<>();

        String input = scanner.nextLine();

        String string1 = input.toLowerCase();
        String string = string1.replace(" ", "");

        int length = string.length();

        for (char str: string.toCharArray()) {
            if (hashMap.containsKey(str)) {
                hashMap.put(str, hashMap.get(str) + 1);
            } else {
                hashMap.put(str, 1);
            }
        }

        Iterator<Integer> iterator = hashMap.values().iterator();
        int oddCount = 0;

        while (iterator.hasNext()) {
            int next = iterator.next() % 2;
            if (next == 1) {
                oddCount++;
            }
        }

        if (length % 2 == 0) {
            if (oddCount != 0) {
                System.out.println("False");
            } else {
                System.out.println("True");
            }
        } else {
            if (oddCount == 1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}
