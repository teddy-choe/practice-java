package algorithm.programmers.compress;

class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.solution("xababcdcdababcdcd"));
    }

    public int solution(String s) {
        int answer = 0;
        int count = 1;
        int min = s.length();
        String preUnit = "";

        if (s.length() == 1) {
            return 1;
        }

        for(int i=1; i<=s.length()/2; i++) {
            String compressString = "";
            count = 1;
            preUnit = "";
            int temp = 0;

            for(int j=0; j<s.length(); j += i) {
                String unit;

                if (j+i > s.length()) {
                    break;
                } else {
                    temp = j+i;
                    unit = s.substring(j, j+i);
                }

                if (unit.equals(preUnit)) {
                    count++;
                } else {
                    if (count >= 2) {
                        compressString += count + preUnit;
                    } else {
                        compressString += preUnit;
                    }

                    preUnit = unit;
                    count = 1;
                }
            }

            if (count >= 2) {
                compressString += count + preUnit;
            } else {
                compressString += preUnit;
            }

            while(temp < s.length()) {
                compressString += String.valueOf(s.charAt(temp++));
            }

            if (compressString.length() < min) {
                min = compressString.length();
            }
        }

        answer = min;

        return answer;
    }
}