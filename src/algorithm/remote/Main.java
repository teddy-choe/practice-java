package algorithm.remote;

import java.util.Scanner;

public class Main {
    static boolean[] banned = new boolean[10];
    static int target;
    static int targetLen;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //목표하는 숫자와 숫자의 길이를 계산해보기
        String str = scanner.nextLine();
        target = Integer.valueOf(str);
        targetLen = str.length();

        int n = scanner.nextInt();

        for (int i=0; i<n; i++) {
            int toBanned = scanner.nextInt();
            banned[toBanned] = true;
        }

        //+와 -만으로 크기 계산
        min = Math.abs(target - 100);

        //채널을 반복하면서 채널과 목표간의 크기를 계산
        for (int i=0; i<900000; i++) {
            if (i == target) {
                if (!check(i)) continue;
                else {
                    if (min > targetLen) min = targetLen;
                }
            }

            if (!check(i)) continue;

            int len = Math.abs(target - i) + targetLen;

            if (min > len) {
                min = len;
            }
        }

        System.out.println(min);
    }

    static boolean check(int num) {
        String temp = String.valueOf(num);

        for (int i=0; i<temp.length(); i++) {
            int toCheck = Integer.parseInt(String.valueOf(temp.charAt(i)));
            if (banned[toCheck]) {
                return false;
            }
        }

        return true;
    }
}
