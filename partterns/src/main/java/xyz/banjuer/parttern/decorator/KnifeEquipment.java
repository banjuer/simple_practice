package xyz.banjuer.parttern.decorator;

public class KnifeEquipment implements Equipment {
    @Override
    public int arm() {
        return 20;
    }

    @Override
    public String desc() {
        return "刀";
    }
}
