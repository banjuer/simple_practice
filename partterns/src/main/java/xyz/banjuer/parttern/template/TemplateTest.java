package xyz.banjuer.parttern.template;

public class TemplateTest {

    public static void main(String[] args) {
        // 模版代码: 定义算法骨架，把特有的实现放到子类实现
        Worker programmer = new Programmer("gcs");
        Worker pm = new ProductManager("wyl");
        programmer.work();
        pm.work();
    }

}
