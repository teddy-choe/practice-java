package algorithm.explode_string;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String explode = scanner.nextLine();
        String result;

        while (input.contains(explode)) {
            input = input.replace(explode, "");
        }

        if (input.equals("")) {
            result = "FRULA";
        } else {
            result = input;
        }

        System.out.println(result);
    }
}
