package xyz.banjuer.parttern.observer;

import java.util.LinkedList;
import java.util.List;

public class Fuli3D implements Subject {

    /**
     * 所有观察者
     */
    private final List<Observer> observers = new LinkedList<>();

    /**
     * 通知的信息
     */
    private String msg;

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(msg));
    }

    public void setMsg(String msg) {
        this.msg = msg;
        this.notifyObservers();
    }

}
