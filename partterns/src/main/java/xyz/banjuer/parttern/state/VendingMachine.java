package xyz.banjuer.parttern.state;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 售货机内维护所有状态
 */
public class VendingMachine implements AutoVendor {

    private AutoVendor paid;
    private AutoVendor unpaid;
    private AutoVendor sold;
    private AutoVendor soldOut;
    private AutoVendor lucky;

    private AutoVendor current;

    /**
     * 售货机商品数量
     */
    private AtomicInteger number;

    public VendingMachine(int count) {
        paid = new PaidState(this);
        unpaid = new UnPaidState(this);
        sold = new SoldState(this);
        soldOut = new SoldOutState();
        lucky = new LuckyState(this);
        this.number = new AtomicInteger(count);
        current = unpaid;
    }

    @Override
    public void payMoney() {
        current.payMoney();
    }

    @Override
    public void backMoney() {
        current.backMoney();
    }

    @Override
    public void chose() {
        current.chose();
    }

    @Override
    public void sold() {
        current.sold();
    }

    public AutoVendor getPaid() {
        return paid;
    }

    public void setPaid(AutoVendor paid) {
        this.paid = paid;
    }

    public AutoVendor getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(AutoVendor unpaid) {
        this.unpaid = unpaid;
    }

    public AutoVendor getSold() {
        return sold;
    }

    public void setSold(AutoVendor sold) {
        this.sold = sold;
    }

    public AutoVendor getSoldOut() {
        return soldOut;
    }

    public void setSoldOut(AutoVendor soldOut) {
        this.soldOut = soldOut;
    }

    public AutoVendor getLucky() {
        return lucky;
    }

    public void setLucky(AutoVendor lucky) {
        this.lucky = lucky;
    }

    public AutoVendor getCurrent() {
        return current;
    }

    public void setCurrent(AutoVendor current) {
        this.current = current;
    }

    public AtomicInteger getNumber() {
        return number;
    }

    public void setNumber(AtomicInteger number) {
        this.number = number;
    }
}
