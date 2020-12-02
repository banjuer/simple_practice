package xyz.banjuer.parttern.state;

public class LuckyState implements AutoVendor {

    private VendingMachine machine;

    public LuckyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void payMoney() {
        System.out.println("幸运奖，非法投币");
    }

    @Override
    public void backMoney() {
        System.out.println("幸运奖，非法退款");
    }

    @Override
    public void chose() {
        System.out.println("幸运奖，非法选择");
    }

    @Override
    public void sold() {
        System.out.println("恭喜中奖，双倍奖励");
        int i = machine.getNumber().get();
        if (i > 2) {
            machine.getNumber().getAndDecrement();
            System.out.println("幸运奖出货成功2倍!");
            machine.setCurrent(machine.getUnpaid());
        } else {
            machine.setCurrent(machine.getSoldOut());
            System.out.println("商品不足,幸运奖失效! 正常出货");
            machine.setCurrent(machine.getSoldOut());
        }
        machine.getNumber().decrementAndGet();
    }
}
