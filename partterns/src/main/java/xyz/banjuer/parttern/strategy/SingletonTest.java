package xyz.banjuer.parttern.strategy;

import xyz.banjuer.parttern.singleton.SingleConfig;

public class SingletonTest {

    public static void main(String[] args) {
        int THREADS = 10;
        // testSingleton(THREADS, new ConfigLazy());
        // testSingleton(THREADS, new ConfigLazyUnsafe());
        // testSingleton(THREADS, new ConfigLazyLoading());
        testSingleton(THREADS, new ConfigHunger());
    }

    /**
     * 对xyz.banjuer.parttern.singleton.SingletonTest测试代码使用策略者模式封装
     * @param threads
     * @param config
     */
    static void testSingleton(int threads, IConfig config) {
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                SingleConfig instance = config.getInstance();
                instance.whoAmI();
            }).start();
        }
    }

}
