package xyz.banjuer.parttern.adapter;

public class PowerV5Adapter implements PowerV5 {

    private PowerV220 v220;

    public PowerV5Adapter(PowerV220 v220) {
        this.v220 = v220;
    }

    @Override
    public int output() {
        System.out.printf("input: %d, output: %d\n", v220.output(), 5);
        return 5;
    }
}
