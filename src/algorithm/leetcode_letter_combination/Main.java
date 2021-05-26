package algorithm.leetcode_letter_combination;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        main.letterCombinations("");
    }

    private List<String> list;
    private String[][] letters = {{"a","b","c"}, {"d","e","f"},
            {"g","h","i"}, {"j","k","l"}, {"m","n","o"},
            {"p","q","r","s"}, {"t","u","v"}, {"w","x","y","z"}};

    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();

        if(digits == "") {
            return null;
        }

        dfs(digits, new StringBuffer(), 0);

        return list;
    }

    private void dfs(String digits, StringBuffer pre, int index) {
        if(index == digits.length()) {
            list.add(pre.toString());
            return;
        }

        int num = (int)digits.charAt(index) - 50;

        for(int i=0; i<4; i++) {
            StringBuffer cur = new StringBuffer(pre.toString());

            if((num == 0 || num == 1 || num == 2 || num == 3 || num == 4 || num == 6) && i == 3 ) {
                break;
            }

            cur.append(letters[num][i]);
            dfs(digits, cur, index+1);
        }
    }
}
