package xyz.banjuer.parttern.state;

public class SoldState implements AutoVendor {

    private VendingMachine machine;

    public SoldState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void payMoney() {
        System.out.println("正在出货，请勿支付");
    }

    @Override
    public void backMoney() {
        System.out.println("正在出货，不可退款");
    }

    @Override
    public void chose() {
        System.out.println("正在出货，不可选择商品");
    }

    @Override
    public void sold() {
        if (machine.getCurrent() == machine.getSoldOut()) {
            System.out.println("出货失败:商品售罄");
        } else {
            System.out.println("正在出货");
            int number = machine.getNumber().decrementAndGet();
            if (number <= 0) {
                machine.setCurrent(machine.getSoldOut());
            } else {
                machine.setCurrent(machine.getUnpaid());
            }
        }
    }
}
