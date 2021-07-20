package algorithm.leetcode.leetcode_atoi;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        String s = "20000000000000000000";
        System.out.print(main.myAtoi(s));
    }

    public int myAtoi(String s) {
        int answer = 0;
        StringBuffer buffer = new StringBuffer();

        // if flag is false, the int is negative
        boolean flag = false;
        boolean isMinus = false;
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            if (flag) {
                if (!Character.isDigit(cur)) {
                    break;
                }
            }

            if (cur == ' ') {
                continue;
            }

            if (cur == '+') {
                flag = true;
                continue;
            }

            if (cur == '-') {
                flag = true;
                isMinus = true;
                continue;
            }

            if (Character.isDigit(cur)) {
                int index = 0;
                while(i+index < s.length() && Character.isDigit(s.charAt(i + index))) {
                    buffer.append(s.charAt(i+index));
                    index++;
                }
                break;
            }

            // other character
            break;
        }

        if (buffer.toString().isEmpty()) {
            return answer;
        }

        String temp = "";

        if (isMinus) {
            temp = "-" + buffer.toString();
        } else {
            temp = buffer.toString();
        }

        long number = Long.valueOf(temp);

        if (number > Integer.MAX_VALUE) {
            answer = Integer.MAX_VALUE;
        } else if (number < Integer.MIN_VALUE) {
            answer = Integer.MIN_VALUE;
        } else {
            answer = (int)number;
        }

        return answer;
    }
}
