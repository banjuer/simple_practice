package xyz.banjuer.parttern.decorator;

public class ShoeEquipment implements Equipment {
    @Override
    public int arm() {
        return 5;
    }

    @Override
    public String desc() {
        return "草鞋";
    }
}
