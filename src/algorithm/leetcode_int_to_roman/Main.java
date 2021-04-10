package algorithm.leetcode_int_to_roman;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.intToRoman(3999));
    }

    int[] romanInt;
    String[] romanAlpha;

    public String intToRoman(int num) {
        String answer = "";

        romanInt = new int[]{1000, 500, 100, 50, 10, 5, 1};
        romanAlpha = new String[]{"M", "D", "C", "L", "X", "V", "I"};

        StringBuffer stringBuffer = new StringBuffer();

        for (int i=3; i>=0; i--) {
            int n = (int) Math.pow(10, i);
            int temp = ((num / n) * n);
            num -= temp;

            switch (temp) {
                case 900 :
                    stringBuffer.append("CM");
                    continue;
                case 400 :
                    stringBuffer.append("CD");
                    continue;
                case 90 :
                    stringBuffer.append("XC");
                    continue;
                case 40 :
                    stringBuffer.append("XL");
                    continue;
                case 9 :
                    stringBuffer.append("IX");
                    continue;
                case 4 :
                    stringBuffer.append("IV");
                    continue;
            }

            while(temp != 0) {
                for (int j=0; j<7; j++) {
                    if (temp >= romanInt[j]) {
                        temp -= romanInt[j];
                        stringBuffer.append(romanAlpha[j]);
                        break;
                    }
                }
            }
        }

        answer = stringBuffer.toString();

        return answer;
    }
}
