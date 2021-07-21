package algorithm.code_ground;

/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
class Solution {
    static String Answer;

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
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = Integer.parseInt(sc.nextLine());
        for(int test_case = 0; test_case < T; test_case++) {

            Answer = "Playing";

            String input = sc.nextLine();
            int a = 0;
            int b = 0;

            for (int i=0; i<input.length(); i++) {
                if (input.charAt(i) == 'A') a++;
                else if (input.charAt(i) == 'B') b++;

                if (a == 21) {
                    Answer = "Alice";
                    break;
                } else if (b == 21) {
                    Answer = "Bob";
                    break;
                }
            }


            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}