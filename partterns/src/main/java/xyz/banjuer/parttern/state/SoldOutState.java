package xyz.banjuer.parttern.state;

public class SoldOutState implements AutoVendor {

    @Override
    public void payMoney() {
        System.out.println("商品售罄，不可支付");
    }

    @Override
    public void backMoney() {
        System.out.println("商品售罄(未支付)，不可退款");
    }

    @Override
    public void chose() {
        System.out.println("商品售罄，不可选择商品");
    }

    @Override
    public void sold() {
        System.out.println("商品售罄，出货失败");
    }
}
