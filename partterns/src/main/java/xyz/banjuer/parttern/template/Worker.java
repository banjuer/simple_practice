package xyz.banjuer.parttern.template;

public abstract class Worker {

    protected String name;

    public Worker(String name) {
        this.name = name;
    }

    abstract void doJob();

    public void work() {
        computerOn();
        doJob();
        computerOff();
    }

    protected void computerOn() {
        System.out.println(name + "打开了电脑");
    }

    protected void computerOff() {
        System.out.println(name + "关闭了电脑");
    }

}
