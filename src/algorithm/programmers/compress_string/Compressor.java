package algorithm.programmers.compress_string;

import java.util.LinkedList;
import java.util.Queue;

public class Compressor {
    public String compress(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        char[] charArray = string.toCharArray();

        for (char c : charArray) {
            queue.add(c);
        }

        char tempStr = queue.poll();
        int count = 1;

        while (!queue.isEmpty()) {
            char tempStr2 = queue.peek();

            if (tempStr == tempStr2) {
                queue.poll();
                count++;
            } else {
                if (count != 1) {
                    stringBuilder.append(count);
                }
                stringBuilder.append(tempStr);
                tempStr = queue.poll();
                count = 1;
            }

            // FIXME: 중복을 어떻게 제거하지?
            if (queue.isEmpty()) {
                if (count != 1) {
                    stringBuilder.append(count);
                }
                stringBuilder.append(tempStr);
            }
        }

        return stringBuilder.toString();
    }
}
