package algorithm.leetcode.test2;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] times = {{1,2},{2,6},{3,4}, {4,5}};

        System.out.println(solution.smallestChair(times, 3));
    }

    class Time implements Comparable<Time> {
        int friendsIndex;
        int time;

        public Time(int friendsIndex, int time) {
            this.friendsIndex = friendsIndex;
            this.time = time;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time < o.time) {
                return -1;
            } else if (this.time > o.time) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    int[] friends;
    boolean[] sits;
    ArrayList<Time> starts;
    ArrayList<Time> ends;

    public int smallestChair(int[][] times, int targetFriend) {
        friends = new int[times.length];
        sits = new boolean[times.length];
        starts = new ArrayList<>();
        ends = new ArrayList<>();
        int result = 0;

        for (int i=0; i<times.length; i++) {
            starts.add(new Time(i, times[i][0]));
            ends.add(new Time(i, times[i][1]));
        }

        Collections.sort(starts);
        Collections.sort(ends);

        for (int i=0; i<100000; i++) {
            if (starts.isEmpty() || ends.isEmpty()) break;

            if (ends.get(0).time == i) {
                sits[friends[ends.get(0).friendsIndex]] = false;
                friends[ends.get(0).friendsIndex] = -1;
                ends.remove(0);
            }

            if (starts.get(0).time == i) {
                for (int j=0; j<sits.length; j++) {
                    if (sits[j] == false) {
                        sits[j] = true;
                        friends[starts.get(0).friendsIndex] = j;

                        if (starts.get(0).friendsIndex == targetFriend) result = j;

                        starts.remove(0);
                        break;
                    }
                }
            }
        }

        return result;
    }
}
