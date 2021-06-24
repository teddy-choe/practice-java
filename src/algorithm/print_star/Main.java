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
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                    stringBuilder.append("*");
                }

                for (int w = 0; w < n-i; w++) {
                    System.out.print(" ");
                    stringBuilder.append(" ");
                }

                String temp = stringBuilder.toString();
                for (int k=temp.length()-1; k>=0; k--) {
                    System.out.print(temp.charAt(k));
                }

                System.out.println();
            }

            for (int i = 1; i<=n; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int w = 0; w < n-i; w++) {
                    System.out.print("*");
                    stringBuilder.append("*");
                }

                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                    stringBuilder.append(" ");
                }

                String temp = stringBuilder.toString();
                for (int k=temp.length()-1; k>=0; k--) {
                    System.out.print(temp.charAt(k));
                }

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
