package xyz.banjuer.parttern.state;

public class StateTest {

    public static void main(String[] args) {
        int COUNT = 20;
        VendingMachine machine = new VendingMachine(COUNT);
        machine.payMoney();
        machine.backMoney();
        machine.sold();

        // machine.chose();
        for (int i = 0; i < 20; i++) {
            System.out.println("===========");
            machine.payMoney();
            machine.chose();
            machine.sold();
        }

    }

}
