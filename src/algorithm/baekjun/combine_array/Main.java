package algorithm.baekjun.combine_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[n+m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        for (int i=0; i<m; i++) {
            b[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int pA = 0;
        int pB = 0;
        int pC = 0;

        while (pA < n && pB < m) {
            if (a[pA] > b[pB]) {
                c[pC++] = b[pB++];
            } else {
                c[pC++] = a[pA++];
            }
        }

        if (pA < n) {
            while (pA < n) {
                c[pC++] = a[pA++];
            }
        } else {
            while (pB < m) {
                c[pC++] = b[pB++];
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int num : c) {
            stringBuffer.append(num + " ");
        }

        System.out.println(stringBuffer.toString());
        bufferedReader.close();
    }
}
