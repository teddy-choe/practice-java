package algorithm.chuseok;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
    }

    public int solution(String[] lines) throws ParseException {
        int answer = 0;

        int totalNum = lines.length;

        Date[][] lineCase = new Date[totalNum][totalNum];

        int index = 0;
        for (String line: lines) {
            String[] temp = line.split(" ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

            Date endTime = simpleDateFormat.parse(temp[0]);
            Date startTime = simpleDateFormat.parse(temp[0]);
            Date operationTime = simpleDateFormat.parse(temp[1]);
            startTime.setSeconds(endTime.getSeconds() - operationTime.getSeconds() + 1);

            index++;
        }

        return answer;
    }
}
