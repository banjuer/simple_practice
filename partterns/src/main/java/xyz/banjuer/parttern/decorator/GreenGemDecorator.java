package xyz.banjuer.parttern.decorator;

public class GreenGemDecorator implements EquipmentDecorator {

    private Equipment equipment;

    public GreenGemDecorator(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public int arm() {
        return equipment.arm() + 5;
    }

    @Override
    public String desc() {
        return equipment.desc() + "+绿宝石";
    }
}
