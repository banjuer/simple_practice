package xyz.banjuer.parttern.builder;

public class AppleBuilder implements ComputerBuilder {

    private Computer computer;

    public AppleBuilder(String type) {
        this.computer = new Computer("apple", type);
    }

    @Override
    public void setOs() {
        String os = null;
        switch (computer.getType()) {
            case "台式机":
            case "笔记本":
                os = "mac os";
                break;
            case "平板":
                os = "ipad os";
                break;
            case "手机":
                os = "ios";
                break;
            default:
                break;
        }
        computer.setOs(os);
    }

    @Override
    public Computer get() {
        return computer;
    }
}
