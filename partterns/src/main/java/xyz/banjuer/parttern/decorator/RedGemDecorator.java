package xyz.banjuer.parttern.decorator;

/**
 * 装饰器需要引入被装饰或修饰的对象
 */
public class RedGemDecorator implements EquipmentDecorator {

    private Equipment equipment;

    public RedGemDecorator(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public int arm() {
        return equipment.arm() + 20;
    }

    @Override
    public String desc() {
        return equipment.desc() + "+红宝石";
    }
}
