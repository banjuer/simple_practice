package xyz.banjuer.parttern.observer;

public interface Subject {

    /**
     * 观察者注册
     * @param o
     */
    void register(Observer o);

    /**
     * 取消注册
     * @param o
     */
    void remove(Observer o);

    /**
     * 通知所有注册
     */
    void notifyObservers();

}
