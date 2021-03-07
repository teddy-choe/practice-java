package longString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindLongString {
    private ArrayList<String> list= new ArrayList<>();
    private String[] stringList;
    private String preString;
    private String keyWord;

    public FindLongString(String preString, String keyWord) {
        this.preString = preString;
        this.keyWord = keyWord;
    }

    private void stringSort() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        };

        stringList = preString.split(" ");

        for (String s: stringList) {
            list.add(s);
        }

        Collections.sort(list, comparator);
    }

    public String findLongString() {
        stringSort();

        for (String string: list) {
            if (string.contains(keyWord)) {
                return string;
            }
        }

        return "not found";
    }
}
