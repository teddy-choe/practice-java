package algorithm.compress;

public class Main {
    public static void main(String[] args) {
        String string = "aabcccaaaa";

        char[] stringArray = string.toCharArray();
        char[] result = new char[string.length()];

        char preWord = stringArray[0];
        int count = 0;
        int resultIndex = 0;
        for (int i=0; i<string.length(); i++) {
            char curWord = stringArray[i];

            if (i == string.length() - 1) {
                result[resultIndex++] = preWord;
                result[resultIndex] = Character.forDigit(count, 10);
            }

            if (preWord == curWord) {
                count++;
            } else {
                result[resultIndex++] = preWord;
                result[resultIndex++] = Character.forDigit(count, 10);

                count = 0;
            }

            preWord = curWord;
        }

        for (char word : result) {
            System.out.print(word);
        }
    }
}
