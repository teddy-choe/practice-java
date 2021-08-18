package java_practice.string_constant_pool;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String test1 = "abc";
        String test2 = "abc";
        String test3 = new String("abc");

        System.out.println(test1==test2);
        System.out.println(test1==test3);
        System.out.println(test1.equals(test3));

        HashMap<String, String> hashMap = new HashMap<>();
    }
}
