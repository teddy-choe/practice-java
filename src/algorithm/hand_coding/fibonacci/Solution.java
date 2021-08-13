package algorithm.hand_coding.fibonacci;

import java.util.Arrays;

/*
 * 0 이상의 정수 n이 주어질 때, n번째 피보나치 수를 구하라
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(recursionFibonacci(5));
        System.out.println(repeatFibonacci(5));
        System.out.println(dynamicFibonacci(5));
    }

    /*
     * 시간 복잡도는 한번 호출마다 두 배씩 문제의 크기가 증가한다. 이렇게 되면?
     */
    static int recursionFibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return recursionFibonacci(n-1) + recursionFibonacci(n-2);
        }
    }

    /*
     * 반복문으로 피보나치 수열을 계산하면 n번의 연산만에 답을 구할 수 있다
     */
    static int repeatFibonacci(int n) {
        if (n < 2) {
            return 1;
        }

        int temp1 = 1;
        int temp2 = 1;
        for (int i=2; i<n; i++) {
            temp2 = temp1+temp2;
            temp1 = temp2;
        }

        return temp2;
    }

    /*
     * Bottom-up 형식의 동적 계획법, 반복문과 연산량은 거의 동일하므로, O(n)만큼의 연산이 필요하다.
     * 단, 공간은 n만큼 더 늘었다고 볼 수 있다.
     */
    static int dynamicFibonacci(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, 0);
        cache[0] = 1;
        cache[1] = 1;

        for (int i=2; i<=n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];
    }
}
