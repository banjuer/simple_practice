package xyz.banjuer.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SleepUtils {

    public static void sleep(int seconds) {
        sleep(seconds, TimeUnit.SECONDS);
    }

    public static void sleep(int timeout, TimeUnit unit) {
        try {
            unit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Map m = new HashMap(7);
    }

}
