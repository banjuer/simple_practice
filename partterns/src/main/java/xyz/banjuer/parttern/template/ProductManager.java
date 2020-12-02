package xyz.banjuer.parttern.template;

public class ProductManager extends Worker {
    public ProductManager(String name) {
        super(name);
    }

    @Override
    void doJob() {
        System.out.println(this.name + "开始看剧...");
    }
}
