package algorithm.baekjun.make_password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static String[] words;
    static ArrayList<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        int l = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        words = new String[c];
        visited = new boolean[c];
        result = new ArrayList<>();

        tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i = 0; i < c; i++) {
            words[i] = tokenizer.nextToken();
        }

        combination(visited, 0, l, c);
        Collections.sort(result);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static void combination(boolean[] visited, int index, int r, int n) {
        if (r == 0) {
            ArrayList<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    list.add(words[i]);
                }
            }

            Collections.sort(list);
            String temp = "";

            for (String str : list) {
                temp += str;
            }

            if (check(temp)) {
                result.add(temp);
            }

            return;
        }

        if (index == n) {
            return;
        }

        visited[index] = true;
        combination(visited, index + 1, r - 1, n);
        visited[index] = false;
        combination(visited, index + 1, r, n);
    }

    public static boolean check(String string) {
        char[] temp = string.toCharArray();
        int vowel = 0;
        int consonant = 0;

        for (char c : temp) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
