package xyz.banjuer.parttern.builder;

public class Computer {

    private String os;

    private String brand;

    private String type;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Computer(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "os='" + os + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
