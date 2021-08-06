/*
 * Programmers, 추석 트래픽 문제
 * https://programmers.co.kr/learn/courses/30/lessons/17676
 */

package algorithm.programmers.chuseok_traffic;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
 * 시작 시간과 종료 시간을 기준으로 트래픽의 갯수가 달라진다.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strings = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
        System.out.println(solution.solution(strings));
    }

    // lines의 데이터에서 각 트래픽 별 시작 시간과 종료 시간을 저장함
    class Times {
        LocalDateTime startTime;
        LocalDateTime endTime;

        public Times(LocalDateTime startTime, LocalDateTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public int solution(String[] lines) {
        int answer = 0;

        List<Times> timesList = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

        // lines에서 Times타입의 리스트를 생성함
        for (String line : lines) {
            String[] splitString = line.split(" ");
            long second = (long) (Float.parseFloat(splitString[2].replace("s", "")) * 1000);
            LocalDateTime endTime = LocalDateTime.parse(splitString[0] + "T" + splitString[1], dateTimeFormatter);
            LocalDateTime startTime = endTime.minus(Duration.ofMillis(second - 1));
            timesList.add(new Times(startTime, endTime));
        }

        for (Times times : timesList) {
            // 시작 시간을 기준으로 1초 구간을 설정함
            LocalDateTime firstStart = times.startTime;
            LocalDateTime firstEnd = times.startTime.plus(Duration.ofMillis(999));

            int count = 1;

            for (Times times1 : timesList) {
                if (times == times1) continue;

                // 1초 구간의 범위 안에 들어오면 count를 증가시킴
                if ((times1.startTime.isBefore(firstEnd) || times1.startTime.isEqual(firstEnd))
                        && (times1.endTime.isAfter(firstStart) || times1.endTime.isEqual(firstStart))) {
                    count++;
                }
            }

            answer = Math.max(answer, count);

            // 종료 시간을 기준으로 1초 구간을 설정함
            LocalDateTime secondStart = times.endTime;
            LocalDateTime secondEnd = times.endTime.plus(Duration.ofMillis(999));
            count = 1;

            for (Times times1 : timesList) {
                if (times == times1) continue;

                if ((times1.startTime.isBefore(secondEnd) || times1.startTime.isEqual(secondEnd))
                        && (times1.endTime.isAfter(secondStart) || times1.endTime.isEqual(secondStart))) {
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
