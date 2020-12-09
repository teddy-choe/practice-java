package algorithm.gcb;

public class Main {
    public static void main(String[] args) {
        Gcb gcbAlgorithm = new Gcb();

        int gcb = gcbAlgorithm.gcb(20, 5);
        System.out.println(gcb);

        int lcm = gcbAlgorithm.lcm(97, 3);
        System.out.println(lcm);
    }
}
