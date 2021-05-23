package xyz.banjuer.test;

import java.util.Random;

public class BaseTest {

    public static void main(String[] args) {
        final Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }

}
