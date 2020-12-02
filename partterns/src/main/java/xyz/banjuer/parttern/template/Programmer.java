package xyz.banjuer.parttern.template;

public class Programmer extends Worker {

    public Programmer(String name) {
        super(name);
    }

    @Override
    void doJob() {
        System.out.println(this.name + "开始写代码...");
    }
}
