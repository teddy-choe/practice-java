package algorithm.gcb;

public class Gcb {
    // a > b
    public int gcb(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }

        int n = 0;
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }

        return a;
    }

    public int lcm(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();
        }

        return (a*b) / gcb(a, b);
    }
}
