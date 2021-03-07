package longString;

public class Main {
    public static void main(String[] args) {
        FindLongString findLongString =
                new FindLongString("test testtest testtesttest test1", "test");

        String result = findLongString.findLongString();

        System.out.println(result);

    }
}
