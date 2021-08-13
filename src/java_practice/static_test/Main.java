package java_practice.static_test;

public class Main {
    static class Test {
        int a;
        static int b = 5;
        public Test(int a) {
            this.a = a;
        }
    }

    public static void main(String[] args) {
        System.out.println(Test.b);

        Test t1 = new Test(1);
        Test t2 = new Test(2);

        System.out.println("t1 a :" + t1.a);
        System.out.println("t2 a :" + t2.a);

        // t1.b == Test.b
        System.out.println("test b :" + Test.b);

        Test.b = 10;

        System.out.println("b :" + Test.b);
    }
}
