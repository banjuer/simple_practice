package xyz.banjuer.parttern.observer;

public class ObserverTest {

    public static void main(String[] args) {
        Fuli3D subject = new Fuli3D();
        UserObserver u1 = new UserObserver(subject, 1);
        UserObserver u2 = new UserObserver(subject, 2);
        subject.setMsg("22,23,12,18 05,06");
    }

}
