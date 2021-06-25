package algorithm.sort_point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x > o.x) {
                return 1;
            } else if (this.x == o.x) {
                if (this.y > o.y) {
                    return 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(bufferedReader.readLine());
            ArrayList<Point> list = new ArrayList<>();

            for (int i=0; i<n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
                list.add(
                        new Point(
                                Integer.parseInt(tokenizer.nextToken()),
                                Integer.parseInt(tokenizer.nextToken())
                        )
                );
            }

            Collections.sort(list);

            for (Point point : list) {
                System.out.println(point.x + " " + point.y);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
