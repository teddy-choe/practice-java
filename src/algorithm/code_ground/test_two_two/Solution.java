package algorithm.code_ground.test_two_two;

/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static int Answer;
    static ArrayList<int[]> result;

    public static void main(String args[]) throws Exception {
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++) {

            // Answer = 0;

            result = new ArrayList<>();
            int n = sc.nextInt();
            int t = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            String temp = sc.nextLine();

            String str = sc.nextLine();
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }

            Arrays.fill(a, -1);
            make(a, b, n, t);

            search(n, t, 0, a, b);

            StringBuilder stringBuilder = new StringBuilder();
            for (int num : result.get(0)) {
                stringBuilder.append(num);
            }

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(stringBuilder.toString());
//            System.out.println(Answer);
        }
    }

    static void search(int n, int t, int index, int[] a, int[] b) {
        if (index == n) {
            if (check(a, b, n, t)) {
                result.add(a.clone());
            }
            return;
        }

        if (a[index] == 0) {
            search(n, t, index+1, a, b);
        } else {
            a[index] = 0;
            search(n, t, index+1, a, b);
            a[index] = 1;
            search(n, t, index+1, a, b);
        }
    }

    private static void make(int[] a, int[] b, int n, int t) {
        for (int i=0; i<n-t; i++) {
            if (b[i] == 0) {
                a[i+t] = 0;
            }
        }

        for (int i=t; i<n; i++) {
            if (b[i] == 0) {
                a[i-t] = 0;
            }
        }
    }

    private static boolean check(int[] a, int[] b, int n, int t) {
        int[] compare = new int[n];

        int index1 = t;
        while (index1 < n) {
            if (a[index1 - t] == 1) {
                compare[index1] = 1;
            }
            index1++;
        }

        int index2 = 0;
        while (index2 < n - t) {
            if (a[index2 + t] == 1) {
                compare[index2] = 1;
            }
            index2++;
        }

        for (int i = 0; i < n; i++) {
            if (compare[i] != b[i]) return false;
        }

        return true;
    }
}