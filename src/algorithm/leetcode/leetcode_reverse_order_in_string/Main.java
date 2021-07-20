package algorithm.leetcode.leetcode_reverse_order_in_string;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String s = "the sky is blue";
        Main main = new Main();

        String str = main.reverseWords(s);
        System.out.println(str);
    }

    public String reverseWords(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 32) {
                if (stringBuffer.length() != 0) {
                    list.add(stringBuffer.toString());
                    stringBuffer = new StringBuffer();
                }
            } else {
                stringBuffer.append(s.charAt(i));
            }
        }

        if (stringBuffer.length() != 0) {
            list.add(stringBuffer.toString());
        }

        for (int i=list.size()-1; i>=0; i--) {
            result.add(list.get(i));
        }

        stringBuffer = new StringBuffer();

        for (String str: result) {
            stringBuffer.append(str);
            stringBuffer.append(" ");
        }

        return stringBuffer.toString();
    }
}
