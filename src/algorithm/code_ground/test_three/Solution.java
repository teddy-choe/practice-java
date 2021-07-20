package algorithm.code_ground.test_three;

/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static boolean hasCycle;
    static ArrayList<String> result;

    public static void main(String args[]) throws Exception	{
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

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

            int n = sc.nextInt();
            int e = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            result = new ArrayList<>();

            for (int i=0; i<=n; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i=0; i<e; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                adjList.get(start).add(end);
            }

            ArrayList<int []> kList = new ArrayList<>();

            for (int i=0; i<k; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();

                kList.add(new int[]{start, end});
            }

            createGraph(kList, adjList, 0, n, k, "");

            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(result.get(0));
        }
    }

    static void createGraph(ArrayList<int []> kList, ArrayList<ArrayList<Integer>> adjList, int depth, int n, int k, String ans) {
        if (depth == k) {
            hasCycle = false;
            checkCycle(adjList, 1, new boolean[n+1], new boolean[n+1]);

            if (!hasCycle) {
                result.add(ans);
            }

            return;
        }

        int first = kList.get(depth)[0];
        int second = kList.get(depth)[1];

        adjList.get(first).add(second);
        createGraph(kList, adjList, depth+1, n, k, ans + "0");

        adjList.get(first).remove((Object)second);
        adjList.get(second).add(first);
        createGraph(kList, adjList, depth+1, n, k, ans + "1");
    }

    static void checkCycle(ArrayList<ArrayList<Integer>> adjList, int node, boolean[] visited, boolean[] recur) {
        visited[node] = true;

        Iterator<Integer> iterator = adjList.get(node).iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (!visited[next]) checkCycle(adjList, next, visited, recur);
            else if (!recur[next]) hasCycle = true;
        }

        recur[node] = true;
    }
}