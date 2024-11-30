package utilities;

import entities.ParkingSpot;
import entities.ParkingTicket;
import utilities.payment.PaymentProcessor;

public class ParkingTicketManager {

    private PaymentProcessor paymentProcessor;

    public void closeTicket(ParkingTicket parkingTicket) {
        parkingTicket.setOutTime();
        paymentProcessor.processPayment(parkingTicket);
        System.out.println("Ticket closed for vehicle " + parkingTicket.getVehicle());
        ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
        parkingSpot.freeUpSpot();
    }

    public ParkingTicketManager() {
        this.paymentProcessor = new PaymentProcessor();
    }

}
