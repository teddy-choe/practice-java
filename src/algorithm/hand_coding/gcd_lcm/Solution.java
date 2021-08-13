package algorithm.hand_coding.gcd_lcm;

/*
 * 유클리드 호제법을 통한 최대공약수와 최소공배수 구하기
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(gcd(120, 36));
        System.out.println(lcm(120, 36));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static int lcm(int a, int b) {
        return (a*b) / gcd(a, b);
    }
}
