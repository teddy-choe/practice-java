package algorithm.string_compress;

import java.lang.String;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        main.solution(orders, course);
    }

    public ArrayList<String> list;

    public String[] solution(String[] orders, int[] course) {
        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> result = new ArrayList();

        for (String order : orders) {
            for (int i = 0; i < order.length(); i++) {
                hashSet.add(String.valueOf(order.charAt(i)));
            }
        }

        ArrayList<String> stringArrayList = new ArrayList<>();
        Iterator iter = hashSet.iterator();
        while (iter.hasNext()) {
            stringArrayList.add((String) iter.next());
        }

        for (int num : course) {
            list = new ArrayList();
            String temp = "";
            combination(stringArrayList, temp, stringArrayList.size(), num, 0);

            for (String str : list) {
                int count = 0;
                for (String order : orders) {
                    boolean isContains = true;

                    for (int i = 0; i < str.length(); i++) {
                        if (!order.contains(String.valueOf(str.charAt(i)))) {
                            isContains = false;
                        }
                    }

                    if (isContains) {
                        count++;
                    }
                }

                if (count >= 2) {
                    result.add(str);
                }
            }
        }

        String[] answer = new String[result.size()];
        int index = 0;

        for (String str : result) {
            answer[index] = str;
            index++;
        }

        return answer;
    }

    public void combination(ArrayList<String> arrayList, String com, int n, int r, int index) {
        if (r == 0) {
            list.add(com);
            return;
        }

        if (index == n) {
            return;
        }

        combination(arrayList, com + arrayList.get(index), n, r-1, index+1);
        combination(arrayList, com, n, r, index+1);
    }
}