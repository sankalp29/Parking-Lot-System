package utilities.payment;

import interfaces.PaymentMode;

public class CashPayment implements PaymentMode {

    @Override
    public void processPayment(int amount) {
        System.out.println("Processed Cash payment of Rs." + amount);
    }

}
