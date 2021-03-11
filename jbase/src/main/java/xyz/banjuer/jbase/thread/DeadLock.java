package xyz.banjuer.jbase.thread;

import xyz.banjuer.common.utils.SleepUtils;

import java.util.concurrent.CountDownLatch;

public class DeadLock {

    static String A = "A";
    static String B = "B";

    static void lockAThenB(String A, String B) {
        synchronized (A) {
            SleepUtils.sleep(1);
            System.out.println(Thread.currentThread().getName() + "获得" + A + "锁");
            synchronized (B) {
                System.out.println(Thread.currentThread().getName() + "获得" + B + "锁");
            }
        }
    }

    public static void main(String[] args) {
        int THREAD_NUMS = 20;
        CountDownLatch latch = new CountDownLatch(THREAD_NUMS);
        for (int i = 0; i < THREAD_NUMS; i++) {
            int finalI = i;
            new Thread(() -> {
                latch.countDown();
                String A = DeadLock.A;
                String B = DeadLock.B;
                if (finalI % 2 == 0) {
                    A = DeadLock.B;
                    B = DeadLock.A;
                }
                lockAThenB(A, B);
            }).start();
        }
    }

}
