package xyz.banjuer.parttern.factory;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("mine shape is " + this.getClass().getSimpleName());
    }
}
