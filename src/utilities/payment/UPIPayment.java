package utilities.payment;

import interfaces.PaymentMode;

public class UPIPayment implements PaymentMode {

    @Override
    public void processPayment(int amount) {
        System.out.println("Processed UPI payment of Rs." + amount);    
    }
    
}
