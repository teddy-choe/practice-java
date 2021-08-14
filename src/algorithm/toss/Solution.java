package algorithm.toss;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Solution {
    public static void main(String[] args) throws ParseException {
        Solution solution = new Solution();
        String[] strings = {"김토스,19900605", "이토스,20020629"};
        System.out.println(solution.solution("20210701", strings));
    }

    public int solution(String date, String[] requests) throws ParseException {
        int answer = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("MMdd");

        int year = Integer.parseInt(date.substring(0, 4));
        Date day = dateFormat.parse(date.substring(4));

        for (String request : requests) {
            String[] requestSplit = request.split(",");
            String requestDate = requestSplit[1];
            int requestYear = Integer.parseInt(requestDate.substring(0, 4));
            Date requestDay = dateFormat.parse(requestDate.substring(4));

            int age = year - requestYear;

            if (day.before(requestDay)) {
                age -= 1;
            }

            if (age >= 19) {
                answer++;
            }
        }

        return answer;
    }
}
