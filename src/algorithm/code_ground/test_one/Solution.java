package algorithm.code_ground.test_one;

/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static int Answer;

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
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();

            // init list
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                int cur = sc.nextInt();

                if ((i + cur) < n) {
                    list.get(i).add(i + cur);
                    list.get(i + cur).add(i);
                }
            }

            int count = 0;
            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs_list(i, list, visited);
                    count++;
                }
            }

            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(count);
        }
    }

    public static void dfs_list(int v, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[v] = true;

        Iterator<Integer> iter = adjList.get(v).listIterator();
        while (iter.hasNext()) {
            int w = iter.next();
            if (!visited[w])
                dfs_list(w, adjList, visited);
        }
    }
}