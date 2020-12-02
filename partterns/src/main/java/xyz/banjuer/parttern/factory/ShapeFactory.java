package xyz.banjuer.parttern.factory;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String type) {
        return null;
    }

    @Override
    public Shape getShape(String type) {
        Shape shape = null;
        switch (type.toUpperCase()){
            case "CIRCLE":
                shape = new Circle();
                break;
            case "SQUARE":
                shape = new Square();
                break;
            case "TRIANGLE":
                shape = new Triangle();
                break;
            default:
                break;
        }
        return shape;
    }
}
