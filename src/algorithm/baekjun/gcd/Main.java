package algorithm.baekjun.gcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            long sum = 0;
            int[] list = new int[Integer.parseInt(stringTokenizer.nextToken())];

            for (int j=0; j<list.length; j++) {
                list[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for (int w=0; w<list.length-1; w++) {
                for (int z=w+1; z<list.length; z++) {
                    int first = list[w];
                    int second = list[z];

                    sum += getGcd(first, second);
                }
            }

            System.out.println(sum);
        }
    }

    static int getGcd(int num1, int num2) {
        if (num2==0) {
            return num1;
        } else {
            return getGcd(num2, num1 % num2);
        }
    }
}
