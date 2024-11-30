package utilities;

import java.time.Duration;

import entities.ParkingTicket;

public class ParkingPrice {

    public static int calculateParkingFees(ParkingTicket parkingTicket) {
        long parkingDuration = Duration.between(parkingTicket.getInTime(), parkingTicket.getOutTime()).toMillis();
        int parkingCostPerHour = parkingTicket.getParkingSpot().getParkingSpotType().getCostPerHour();
        return (int) (parkingDuration * parkingCostPerHour);
    }
}
