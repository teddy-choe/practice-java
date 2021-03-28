package algorithm.sortsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mean = 0;
        double sum = 0;
        int prequen = 0;
        int maxValue = Integer.MIN_VALUE;

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        scanner.nextLine();
        int[] prequency = new int[8001];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i=0; i<num; i++) {
            int input = scanner.nextInt();
            arrayList.add(input);
            prequency[input + 4000] += 1;
        }

        if (arrayList.size() == 1) {
            System.out.println(arrayList.get(0));
            System.out.println(arrayList.get(0));
            System.out.println(arrayList.get(0));
            System.out.println(0);

            return;
        }

        Collections.sort(arrayList);

        for (int number: arrayList) {
            sum += number;
        }

        mean = (int) Math.round(sum / num);

        int center = arrayList.get(num / 2);

        for (int i=0; i<prequency.length; i++) {
            if (prequency[i] > maxValue) {
                maxValue = prequency[i];
            }
        }

        int count = 0;
        for (int i=0; i<prequency.length; i++) {
            if (prequency[i] == maxValue) {
                prequen = i-4000;
                count++;
                if (count == 2) {
                    prequen = i-4000;
                    break;
                }
            }
        }

        int range = arrayList.get(arrayList.size()-1) - arrayList.get(0);

        System.out.println(mean);
        System.out.println(center);
        System.out.println(prequen);
        System.out.println(range);
    }
}
