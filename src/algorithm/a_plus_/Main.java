package algorithm.a_plus_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String temp = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();

            for (int i=0; i<temp.length(); i++) {
                stringBuilder.append(temp.charAt(i));

                if (i % 10 == 9) {
                    System.out.println(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
            }

            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            return;
        }
    }
}
