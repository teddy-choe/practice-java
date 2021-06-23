package algorithm.a_plus_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    private static int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            int sumDay = 0;

            for (int i=1; i<x; i++) {
                sumDay += month[i-1];
            }

            sumDay+= y-1;
            int dayNum = sumDay % 7;
            System.out.println(day[dayNum]);
        } catch (IOException e) {
            return;
        }
    }
}
