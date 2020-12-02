package xyz.banjuer.parttern.state;

import java.util.Random;

public class PaidState implements AutoVendor {

    private VendingMachine machine;

    public PaidState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void payMoney() {
        System.out.println("已支付，请勿重新支付");
    }

    @Override
    public void backMoney() {
        System.out.println("退款成功!");
        machine.setCurrent(machine.getUnpaid());
    }

    @Override
    public void chose() {
        if (machine.getCurrent() == machine.getSoldOut()) {
            System.out.println("已售罄,不可选择商品");
            return;
        }
        System.out.println("正在选择商品...");
        int i = new Random().nextInt(10);
        // 中奖
        if (i == 0 && machine.getCurrent() != machine.getSoldOut()) {
            machine.setCurrent(machine.getLucky());
        } else {
            machine.setCurrent(machine.getSold());
        }
    }

    @Override
    public void sold() {
        System.out.println("正在选择商品，非法售出");
    }
}
