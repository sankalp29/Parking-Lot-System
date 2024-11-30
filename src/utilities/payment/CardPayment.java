package utilities.payment;

import interfaces.PaymentMode;

public class CardPayment implements PaymentMode {

    @Override
    public void processPayment(int amount) {
        System.out.println("Processed Card payment of Rs." + amount);
    }

}
