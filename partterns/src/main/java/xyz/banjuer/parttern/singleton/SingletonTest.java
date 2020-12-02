package xyz.banjuer.parttern.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        int THREADS = 10;
        // testHunger(THREADS);
        // testLazy(THREADS);
        // testLazyLoading(THREADS);
        testLazyUnsafe(THREADS);
    }

    static void testLazyUnsafe(int threads) {
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                SingleConfig hunger = SingleConfig.getInstanceLazyUnsafe();
                hunger.whoAmI();
            }).start();
        }
    }

    static void testHunger(int threads) {
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                SingleConfig hunger = SingleConfig.getInstanceHunger();
                hunger.whoAmI();
            }).start();
        }
    }

    static void testLazy(int threads) {
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                SingleConfig hunger = SingleConfig.getInstanceLazy();
                hunger.whoAmI();
            }).start();
        }
    }

    static void testLazyLoading(int threads) {
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                SingleConfig hunger = SingleConfig.getInstanceLazyLoading();
                hunger.whoAmI();
            }).start();
        }
    }

}
