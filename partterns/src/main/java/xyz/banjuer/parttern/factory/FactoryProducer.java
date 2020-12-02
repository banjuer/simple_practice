package xyz.banjuer.parttern.factory;

public class FactoryProducer {

    public static AbstractFactory produce(String type) {
        AbstractFactory factory = null;
        switch (type.toUpperCase()){
            case "SHAPE":
                factory = new ShapeFactory();
                break;
            case "COLOR":
                factory = new ColorFactory();
                break;
            default:
                break;
        }
        return factory;
    }

}
