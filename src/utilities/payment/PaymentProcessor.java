package utilities.payment;

import entities.ParkingTicket;
import interfaces.PaymentMode;
import utilities.ParkingPrice;

public class PaymentProcessor {

    public void processPayment(ParkingTicket parkingTicket) {
        int parkingFees = ParkingPrice.calculateParkingFees(parkingTicket);
        PaymentMode paymentMode = PaymentModeSelector.selectPaymentMode();
        paymentMode.processPayment(parkingFees);
    }
}
