package algorithm.leetcode.contest3;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minTimeToType("abc");
    }

    class TypeWriter {
        int current = 1;

        int moveLeft() {
            current -= 1;
            if (current <= 0) {
                current = 26;
            }

            return current;
        }

        int moveRight() {
            current += 1;
            if (current >= 27) {
                current = 1;
            }

            return current;
        }
    }

    public int minTimeToType(String word) {
        int count = 0;
        TypeWriter typeWriter = new TypeWriter();

        for (int i=0; i<word.length(); i++) {
            int target = word.charAt(i) - 96;
            int counter = 0;
            int normal = 0;
            int current = typeWriter.current;

            while (true) {
                if (typeWriter.current == target) {
                    break;
                } else {
                    typeWriter.moveLeft();
                    counter++;
                }
            }

            // init before counterClock
            typeWriter.current = current;

            while (true) {
                if (typeWriter.current == target) {
                    break;
                } else {
                    typeWriter.moveRight();
                    normal++;
                }
            }

            if (counter < normal) {
                count += counter;
            } else {
                count += normal;
            }

            count += 1;
        }

        return count;
    }
}
