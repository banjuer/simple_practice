package xyz.banjuer.parttern.factory;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("mine color is " + this.getClass().getSimpleName());
    }
}
