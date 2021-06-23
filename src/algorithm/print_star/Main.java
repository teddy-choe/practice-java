package algorithm.print_star;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        try {
            n = Integer.parseInt(bufferedReader.readLine());

            for (int i = 1; i<=n; i++) {
                int limit = n-i;
                for (int j=0; j<n; j++) {
                    if (j >= limit) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
