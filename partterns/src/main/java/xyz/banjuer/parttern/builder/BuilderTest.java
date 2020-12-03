package xyz.banjuer.parttern.builder;

public class BuilderTest {

    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        ComputerBuilder apple = new AppleBuilder("笔记本");
        director.make(apple);
        System.out.println(apple.get());
        ComputerBuilder sz = new ShenZhouBuilder("台式机");
        director.make(sz);
        System.out.println(sz.get());
    }

}
