package xyz.banjuer.parttern.observer;

public interface Observer {

    /**
     * 注册者收到的消息
     */
    void update(String msg);

}
