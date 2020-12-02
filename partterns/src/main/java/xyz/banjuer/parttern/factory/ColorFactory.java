package xyz.banjuer.parttern.factory;

public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String type) {
        Color color = null;
        switch (type.toUpperCase()){
            case "RED":
                color = new Red();
                break;
            case "GREEN":
                color = new Green();
                break;
            case "YELLOW":
                color = new Yellow();
                break;
            default:
                break;
        }
        return color;
    }

    @Override
    public Shape getShape(String type) {
        return null;
    }
}
