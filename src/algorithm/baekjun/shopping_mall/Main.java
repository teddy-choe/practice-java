package algorithm.baekjun.shopping_mall;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class CurrentUser implements Comparable<CurrentUser>{
        int userId;
        int operateTime;
        int casherNum;

        public CurrentUser(int userId, int operateTime, int casherNum) {
            this.userId = userId;
            this.operateTime = operateTime;
            this.casherNum = casherNum;
        }

        @Override
        public int compareTo(CurrentUser o) {
            if (this.operateTime > o.operateTime) {
                return 1;
            } else if (this.operateTime < o.operateTime) {
                return -1;
            } else {
                if (this.casherNum < o.casherNum) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long total = 0;

        PriorityQueue<Integer> casher = new PriorityQueue<>();
        PriorityQueue<CurrentUser> current = new PriorityQueue<>();
        Queue<int[]> users = new LinkedList<>();

        for (int i=0; i<k; i++) {
            casher.add(i);
        }

        for (int i=0; i<n; i++) {
            users.add(new int[]{scanner.nextInt(), scanner.nextInt()});
        }

        int count = 1;
        int time = 0;

        while (true) {

            if (!current.isEmpty()) {
                int curTime = current.peek().operateTime;

                while (!current.isEmpty() && current.peek().operateTime == curTime) {
                    CurrentUser finishUser = current.poll();
                    total += finishUser.userId * count++;
                    casher.add(finishUser.casherNum);
                    time = finishUser.operateTime;
                }
            }

            while (!casher.isEmpty() && !users.isEmpty()) {
                int[] user = users.poll();
                int casherNum = casher.poll();
                current.add(new CurrentUser(user[0], time + user[1], casherNum));
            }

            if (current.isEmpty())
                break;

        }

        System.out.println(total);
    }
}
