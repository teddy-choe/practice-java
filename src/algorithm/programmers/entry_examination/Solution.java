package algorithm.programmers.entry_examination;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long max = 0;

        for (int time: times) {
            max = Math.max(max, time);
        }

        max = max * n;

        long start = 0;
        long end = max;
        while (start <= end) {
            long mid = (start + end) / 2;

            long possible = 0;

            for (int time: times) {
                possible += mid / time;
            }

            if (possible >= n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        answer = end;

        return answer;
    }
}
