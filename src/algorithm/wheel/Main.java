package algorithm.wheel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class Wheel {
        int[] number;
        boolean isAlreadyRotate = false;

        public Wheel(String numberString) {
            number = new int[8];

            for (int i=0; i<8; i++) {
                number[i] = Character.getNumericValue(numberString.charAt(i));
            }
        }

        public void rotateClockwise() {
            int[] newNumber = new int[8];

            for (int i=0; i<7; i++) {
                newNumber[i+1] = number[i];
            }

            newNumber[0] = number[7];
            number = newNumber;
        }

        public void rotateCounterClockwise() {
            int[] newNumber = new int[8];

            for (int i=0; i<7; i++) {
                newNumber[i] = number[i+1];
            }

            newNumber[7] = number[0];
            number = newNumber;
        }

        public int getLeftRect() {
            return number[6];
        }

        public int getRightRect() {
            return number[2];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Wheel> wheels = new ArrayList<>();

        for (int i=0; i<4; i++) {
            wheels.add(new Wheel(scanner.nextLine()));
        }

        int testNum = scanner.nextInt();

        for (int i=0; i<testNum; i++) {
            int wheelNum = scanner.nextInt() - 1;
            int rotateDirection = scanner.nextInt();

            rotateWheel(wheels, wheelNum, rotateDirection);

            for (int j=0; j<4; j++) {
                wheels.get(j).isAlreadyRotate = false;
            }
        }

        int total = 0;

        for (int i=0; i<4; i++) {
            if (wheels.get(i).number[0] == 1) {
                total += Math.pow(2, i);
            }
        }

        System.out.println(total);
    }

    public static void rotateWheel(ArrayList<Wheel> wheels, int wheelNum, int rotateDirection) {
        wheels.get(wheelNum).isAlreadyRotate = true;

        if (wheelNum-1 != -1 && wheels.get(wheelNum-1).getRightRect() != wheels.get(wheelNum).getLeftRect()
                && !wheels.get(wheelNum-1).isAlreadyRotate) {
            if (rotateDirection == 1) {
                rotateWheel(wheels, wheelNum-1, -1);
            } else {
                rotateWheel(wheels, wheelNum-1, 1);
            }
        }

        if (wheelNum+1 != 4 && wheels.get(wheelNum+1).getLeftRect() != wheels.get(wheelNum).getRightRect()
                && !wheels.get(wheelNum+1).isAlreadyRotate) {
            if (rotateDirection == 1) {
                rotateWheel(wheels, wheelNum+1, -1);
            } else {
                rotateWheel(wheels, wheelNum+1, 1);
            }
        }

        if (rotateDirection == 1) {
            wheels.get(wheelNum).rotateClockwise();
        } else {
            wheels.get(wheelNum).rotateCounterClockwise();
        }
    }
}
