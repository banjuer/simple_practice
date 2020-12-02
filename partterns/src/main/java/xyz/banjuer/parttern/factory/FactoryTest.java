package xyz.banjuer.parttern.factory;

public class FactoryTest {

    public static void main(String[] args) {
        AbstractFactory color = FactoryProducer.produce("color");
        AbstractFactory shape = FactoryProducer.produce("shape");
        Color red = color.getColor("red");
        red.fill();
        Shape circle = shape.getShape("circle");
        circle.draw();
    }

}
