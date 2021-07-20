package algorithm.baekjun.grab_num;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        ArrayList<Integer> negativeAndZero = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        int n = scanner.nextInt();

        for (int i=0; i<n; i++) {
            int num = scanner.nextInt();

            if (num > 0) positive.add(num);
            else negativeAndZero.add(num);
        }

        Collections.sort(negativeAndZero);
        Collections.sort(positive);

        if (negativeAndZero.size() == 1) {
            sum += negativeAndZero.get(0);
        } else if (negativeAndZero.size() > 1) {
            for (int i=0; i<negativeAndZero.size(); i+=2) {
                if (i == negativeAndZero.size()-1) {
                    sum += negativeAndZero.get(i);
                } else {
                    sum += negativeAndZero.get(i) * negativeAndZero.get(i+1);
                }
            }
        }

        if (positive.size() == 1) {
            sum += positive.get(0);
        } else if (positive.size() > 1) {
            for (int i=positive.size()-1; i>=0; i-=2) {
                if (i == 0) {
                    sum += positive.get(0);
                } else {
                    int curSum = positive.get(i) + positive.get(i-1);
                    int curMul = positive.get(i) * positive.get(i-1);
                    if (curSum > curMul) {
                        sum += curSum;
                    } else {
                        sum += curMul;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
