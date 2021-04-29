package algorithm.printer_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class PrintJob {
        int index;
        int value;

        public PrintJob(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i=0; i<testCase; i++) {
            int workSize = sc.nextInt();
            int searchIdx = sc.nextInt();
            int answer = 0;

            Queue<PrintJob> queue = new LinkedList<>();

            int index = 0;
            for (int j=0; j<workSize; j++) {
                queue.add(new PrintJob(index++, sc.nextInt()));
            }

            int pollCount = 1;
            while (!queue.isEmpty()) {
                int maxValue = 0;

                for (int w=0; w<queue.size(); w++) {
                    PrintJob temp = queue.poll();
                    if (temp.value > maxValue) {
                        maxValue = temp.value;
                    }
                    queue.add(temp);
                }

                if (queue.peek().value == maxValue) {
                    if (queue.peek().index == searchIdx) {
                        answer = pollCount;
                        break;
                    } else {
                        queue.poll();
                        pollCount++;
                    }
                } else {
                    PrintJob temp = queue.poll();
                    queue.add(temp);
                }
            }

            System.out.println(answer);
        }

        sc.close();
    }
}
