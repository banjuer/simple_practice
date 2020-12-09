package xyz.banjuer.jbase.oo;

public class Foo {

    private String a = "a";

    public Foo(String a) {
        System.out.println("before construct a:" + this.a);
        this.a = a;
        System.out.println("after a:" + this.a);
    }

    public static void main(String[] args) {
        // init() 对象初值(虚拟机创建完毕后，java程序初始化函数), constructor 自定义构造值
        Foo f = new Foo("b");
    }

}
