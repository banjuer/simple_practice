package xyz.banjuer.parttern.builder;

public class ShenZhouBuilder implements ComputerBuilder {

    private Computer computer;

    public ShenZhouBuilder(String type) {
        this.computer = new Computer("shenzhou", type);
    }

    @Override
    public void setOs() {
        computer.setOs("Windows");
    }

    @Override
    public Computer get() {
        return computer;
    }
}
