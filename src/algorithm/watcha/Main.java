package algorithm.watcha;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static float[] priorityList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String priority = scanner.nextLine();
        String[] priorityString = priority.split(" ");
        priorityList = new float[priorityString.length];
        PriorityQueue<ContentModel> contentModelsY = new PriorityQueue<>();
        PriorityQueue<ContentModel> contentModelsO = new PriorityQueue<>();

        for (int i=0; i<priorityString.length; i++) {
            priorityList[i] = Float.parseFloat(priorityString[i]);
        }

        int h = Integer.parseInt(scanner.next());
        int w = Integer.parseInt(scanner.next());

        char[][] matrix1 = new char[h][w];
        char[][] matrix2 = new char[h][w];

        scanner.nextLine();

        for (int i=0; i<h; i++) {
            matrix1[i] = scanner.nextLine().toCharArray();
        }

        for (int i=0; i<h; i++) {
            matrix2[i] = scanner.nextLine().toCharArray();
        }

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                if (matrix1[i][j] == 'W') {
                    continue;
                }

                if (matrix1[i][j] == 'Y') {
                    contentModelsY.add(new ContentModel(
                            String.valueOf(matrix2[i][j]),
                            getPriorityScore(matrix2[i][j]),
                            String.valueOf(matrix1[i][j]),
                            i + " " + j));
                    continue;
                }

                if (matrix1[i][j] == 'O') {
                    contentModelsO.add(new ContentModel(
                            String.valueOf(matrix2[i][j]),
                            getPriorityScore(matrix2[i][j]),
                            String.valueOf(matrix1[i][j]),
                            i + " " + j));
                    continue;
                }
            }
        }

        while (!contentModelsY.isEmpty()) {
            System.out.println(contentModelsY.poll());
        }

        while (!contentModelsO.isEmpty()) {
            System.out.println(contentModelsO.poll());
        }
    }

    private static float getPriorityScore(char type) {
        switch (type) {
            case 'A':
                return priorityList[0];

            case 'B':
                return priorityList[1];

            case 'C':
                return priorityList[2];

            case 'D':
                return priorityList[3];

            default:
                return priorityList[4];

        }
    }

    public static class ContentModel implements Comparable<ContentModel> {
        String genre;
        float genrePriority;
        String playType;
        String position;

        ContentModel(String genre, float genrePriority, String playType, String position) {
            this.genre = genre;
            this.genrePriority = genrePriority;
            this.playType = playType;
            this.position = position;
        }


        @Override
        public int compareTo(ContentModel o) {
//            if (!this.playType.equals(o.playType)) {
//                return this.playType == "Y" ? -1: 1;
//            } else {
//                return this.genrePriority >= o.genrePriority ? -1: 1;
//            }

            return this.genrePriority >= o.genrePriority ? -1: 1;
        }

        @Override
        public String toString() {
            return genre + ' ' + genrePriority + ' ' + position;
        }
    }
}
