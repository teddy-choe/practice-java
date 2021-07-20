package algorithm.baekjun.set_room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static class Schedule implements Comparable<Schedule>{
        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            if (this.end > o.end) {
                return 1;
            }
            else if (this.end == o.end) {
                if (this.start > o.start) {
                    return 1;
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Schedule> scheduleArrayList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            scheduleArrayList.add(new Schedule(start, end));
        }

        Collections.sort(scheduleArrayList);

        int time = 0;
        int count = 0;

        for (Schedule schedule: scheduleArrayList) {
            if (schedule.start >= time) {
                count++;
                time = schedule.end;
            }
        }

        System.out.println(count);
    }
}
