package xyz.banjuer.parttern.decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        // 装饰器模式: 扩展对象功能。（引入对象）
        EquipmentDecorator shoeDecorator = new RedGemDecorator(new BlueGemDecorator(new ShoeEquipment()));
        System.out.printf("装备:%s 武力值:%d\n", shoeDecorator.desc(), shoeDecorator.arm());

        EquipmentDecorator knifeDecorator = new GreenGemDecorator(new RedGemDecorator(new KnifeEquipment()));
        System.out.printf("装备:%s 武力值:%d\n", knifeDecorator.desc(), knifeDecorator.arm());
    }

}
