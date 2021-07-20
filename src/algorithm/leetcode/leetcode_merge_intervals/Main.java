package algorithm.leetcode.leetcode_merge_intervals;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int[][] intervals = {{1,4}, {4,5}};

        main.merge(intervals);
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> resultList = new ArrayList<>();

        int count = 0;
        for (int i=0; i<intervals.length; i++) {
            if (i+1 != intervals.length && intervals[i][1] >= intervals[i+1][0]) {
                count++;
            } else {
                if (count != 0) {
                    int startIdx = i - count;
                    int endIdx = i;

                    resultList.add(new int[]{intervals[startIdx][0], intervals[i][1]});
                    count = 0;
                } else {
                    resultList.add(intervals[i]);
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][2]);
    }
}
