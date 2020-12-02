package xyz.banjuer.parttern.singleton;

import java.util.Random;

public class SingleConfig {

    private static final SingleConfig CONFIG = new SingleConfig();

    /**
     * 简单的对象标示，用于判断是否创建了多个实例
     * REMARK: 由于是随机数，并未能完全代表同一个id是同一个对象。可以使用其他唯一id如uuid，或自己维护id使用情况
     */
    private final int myid;

    private static volatile SingleConfig config;

    private SingleConfig(){
        this.myid = new Random().nextInt();
        try {
            // 模拟大对象初始化(耗时长)
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void whoAmI() {
        System.out.printf("current thread is: %d, singleton id is: %d \n", Thread.currentThread().getId(), myid);
    }

    public static SingleConfig getInstanceLazy(){
        if (config == null) {
            synchronized (SingleConfig.class) {
                if (config == null) {
                    config = new SingleConfig();
                }
            }
        }
        return config;
    }

    public static SingleConfig getInstanceLazyUnsafe(){
        if (config == null) {
            config = new SingleConfig();
        }
        return config;
    }

    public static SingleConfig getInstanceHunger(){
        return CONFIG;
    }

    public static SingleConfig getInstanceLazyLoading() {
        return SingleHolder.INSTANCE;
    }

    /**
     * lazy-loading
     * 当类被访问时才进行加载
     */
    private static class SingleHolder{
        private static final SingleConfig INSTANCE = new SingleConfig();
    }

}
