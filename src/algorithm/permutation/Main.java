package algorithm.permutation;

public class Main {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();

        String testStr = "123";
        permutation.permute(testStr.toCharArray(), 0, 2);
    }
}
