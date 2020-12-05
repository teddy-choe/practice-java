package algorithm.compress_string;

public class Main {
    public static void main(String[] args) {
        Compressor compressor = new Compressor();

        String string = "aaaabbcdddd";

        String result = compressor.compress(string);
        System.out.println(result);
    }
}
