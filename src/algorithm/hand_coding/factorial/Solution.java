package algorithm.hand_coding.factorial;

public class Solution {
    public static void main(String[] args) {
        System.out.println(recursiveFactorial(10));
        System.out.println(repeatFactorial(10));
    }

    static int repeatFactorial(int n) {
        if (n < 2) {
            return 1;
        }

        int result = 1;
        for (int i=2; i<=n; i++) {
            result *= i;
        }

        return result;
    }

    static int recursiveFactorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * recursiveFactorial(n-1);
    }
}
