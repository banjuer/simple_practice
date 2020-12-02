package xyz.banjuer.parttern.state;

public class UnPaidState implements AutoVendor {

    private VendingMachine machine;

    public UnPaidState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void payMoney() {
        System.out.println("支付成功");
        machine.setCurrent(machine.getPaid());
    }

    @Override
    public void backMoney() {
        System.out.println("未支付，不可退款");
    }

    @Override
    public void chose() {
        System.out.println("未支付，不可选择商品");
    }

    @Override
    public void sold() {
        System.out.println("未支付，不可售出商品");
    }
}
