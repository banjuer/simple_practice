package xyz.banjuer.parttern.observer;

public class UserObserver implements Observer {

    private final int id;

    public UserObserver(Subject subject, int id) {
        this.id = id;
        subject.register(this);
    }

    @Override
    public void update(String msg) {
        System.out.printf("id:%d receive number:%s", id, msg);
        System.out.println();
    }
}
