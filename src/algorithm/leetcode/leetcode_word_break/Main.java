package algorithm.leetcode.leetcode_word_break;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String s = "catsandog";
        List<String> wordDict = new ArrayList();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(main.wordBreak(s,wordDict));
    }

    private boolean isBreakWord;


    public boolean wordBreak(String s, List<String> wordDict) {
        isBreakWord = false;
        search(s, wordDict);
        return isBreakWord;
    }

    public void search(String str, List<String> wordDict) {
        if (str.length() == 0) {
            isBreakWord = true;
            return;
        }

        for (int i=1; i<=str.length(); i++) {
            String subStr = str.substring(0, i);

            if (wordDict.contains(subStr)) {
                search(str.substring(i), wordDict);
            }
        }
    }
}
