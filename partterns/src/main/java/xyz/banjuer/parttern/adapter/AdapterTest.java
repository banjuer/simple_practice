package xyz.banjuer.parttern.adapter;

public class AdapterTest {

    public static void main(String[] args) {
        // 适配器核心是adapter设计。适配器实现目标接口，内部引用已有对象
        // 已有PowerV220接口
        PowerV220 v220 = new PowerV220();
        // 通过是适配器接受目标接口，吐出需求接口
        PowerV5 v5 = new PowerV5Adapter(v220);

        MyPhone phone = new MyPhone();
        // 目标应用程序需要接口PowerV5
        phone.charge(v5);
    }

}
