package algorithm.leetcode.leetcode_regular_expression;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String s = "ab";
        String p = ".*c";
        System.out.println(main.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        boolean answer = false;

        int inputIndex = 0;
        int patternIndex = 0;

        while(patternIndex < p.length() && inputIndex < s.length()) {
            char current = p.charAt(patternIndex);

            if (Character.isAlphabetic(current)) {
                if (patternIndex != p.length()-1 && p.charAt(patternIndex+1) == '*') {
                    while (inputIndex < s.length() && s.charAt(inputIndex) == current) {
                        inputIndex++;
                    }
                } else {
                    if (s.charAt(inputIndex) == current) {
                        inputIndex++;
                    } else {
                        break;
                    }
                }
            }

            if (current == '.') {
                if (patternIndex != p.length()-1 && p.charAt(patternIndex+1) == '*') {
                    while (inputIndex < s.length()) {
                        inputIndex++;
                    }
                } else {
                    inputIndex++;
                }
            }

            patternIndex++;
        }

        if (inputIndex == s.length()) {
            answer = true;
        }

        return answer;
    }
}
