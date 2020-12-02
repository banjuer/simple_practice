package xyz.banjuer.parttern.decorator;

public class BlueGemDecorator implements EquipmentDecorator {
    private Equipment equipment;

    public BlueGemDecorator(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public int arm() {
        return equipment.arm() + 10;
    }

    @Override
    public String desc() {
        return equipment.desc() + "+蓝宝石";
    }
}
