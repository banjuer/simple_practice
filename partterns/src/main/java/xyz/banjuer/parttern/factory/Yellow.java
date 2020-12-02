package xyz.banjuer.parttern.factory;

public class Yellow implements Color {
    @Override
    public void fill() {
        System.out.println("mine color is " + this.getClass().getSimpleName());
    }
}
