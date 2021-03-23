package algorithm.socar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        String[] meetTimes = new String[people];

        for (int i=0; i<people; i++) {
            meetTimes[i] = scanner.nextLine();
        }

        printAllAvailableMeetTime(meetTimes);
    }

    private static void printAllAvailableMeetTime(String[] meetTimes) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        Date latestStartTime = null;
        Date earliestEndTime = null;

        ArrayList<Date> startTimes = new ArrayList<>();
        ArrayList<Date> endTimes = new ArrayList<>();

        for (String meetTime: meetTimes) {
            String[] tempTimes = meetTime.split(" ");

            startTimes.add(simpleDateFormat.parse(tempTimes[0]));
            endTimes.add(simpleDateFormat.parse(tempTimes[2]));
        }

        for (Date startTime : startTimes) {
            if (latestStartTime == null) {
                latestStartTime = startTime;
            }

            int compare = startTime.compareTo(latestStartTime);

            if (compare > 0) {
                latestStartTime = startTime;
            }
        }

        for (Date endTime : endTimes) {
            if (earliestEndTime == null) {
                earliestEndTime = endTime;
            }

            int compare = endTime.compareTo(earliestEndTime);

            if (compare < 0) {
                earliestEndTime = endTime;
            }
        }

        int compare = latestStartTime.compareTo(earliestEndTime);

        if (compare > 0) {
            System.out.println(-1);
        } else {
            System.out.println(simpleDateFormat.format(latestStartTime) + " ~ " + simpleDateFormat.format(earliestEndTime));
        }
    }
}
