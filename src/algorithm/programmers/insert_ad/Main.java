package algorithm.programmers.insert_ad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        Main main = new Main();

        System.out.println(main.solution(play_time, adv_time, logs));
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        if (adv_time.equals(play_time)) {
            return "00:00:00";
        }

        Long playTime = 0L;
        Long playStartTime = 0L;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM:ss");

        // loop돌면서 log의 시작시간과 종료 시간을 기준으로 공익광고 시작 시간을 잡아본다
        for (String log: logs) {
            String[] logTime = log.split("-");

            for (int i=0; i<2; i++) {
                Long caseResult = 0L;
                Long advStart = null;
                Long advEnd = null;

                for (String logCase: logs) {
                    Long logStart = null;
                    Long logEnd = null;

                    String[] logCaseTime = log.split("-");

                    try {
                        advStart = simpleDateFormat.parse(logTime[i]).getTime() / 1000;
                        advEnd = advStart + simpleDateFormat.parse(adv_time).getTime() / 1000;

                        logStart = simpleDateFormat.parse(logCaseTime[0]).getTime() / 1000;
                        logEnd = simpleDateFormat.parse(logCaseTime[1]).getTime() / 1000;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    // 아예 겹치지 않는 경우
                    if (logEnd < advStart || logStart > advEnd) {
                        break;
                    }

                    Long resultStart = 0L;
                    Long resultEnd = 0L;

                    if (logStart <= advStart) {
                        resultStart = advStart;
                    } else {
                        resultStart = logStart;
                    }

                    if (logEnd <= advEnd) {
                        resultEnd = logEnd;
                    } else {
                        resultEnd = advEnd;
                    }

                    Long result = resultEnd - resultStart;
                    caseResult += result;
                }

                if (caseResult > playTime) {
                    playTime = caseResult;
                    playStartTime = advStart;

                } else if (playTime == caseResult) {
                    if (playStartTime > advStart) {
                        playStartTime = advStart;
                    }
                }
            }
        }

        Date resultDate = new Date(playStartTime*1000);
        answer = simpleDateFormat.format(resultDate);;

        return answer;
    }
}
