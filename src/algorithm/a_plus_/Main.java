package algorithm.a_plus_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);

                System.out.println(a+b);
            }
        } catch (IOException e) {
            return;
        }
    }
}
