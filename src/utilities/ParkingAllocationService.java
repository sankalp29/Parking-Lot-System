package utilities;

import java.util.List;

import entities.ParkingSpot;
import entities.ParkingTicket;
import entities.Vehicle;
import enums.VehicleType;
import exceptions.NoParkingAvailableException;

public class ParkingAllocationService {

    public ParkingTicket allocateParking(Vehicle vehicle, List<ParkingSpot> parkingSpots) {
        ParkingSpot parkingSpot = findFreeParkingSpot(vehicle.getVehicleType(), parkingSpots);
        parkingSpot.reserveSpot();
        ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot);
        vehicle.setParkingTicket(parkingTicket);

        System.out.println("ParkingSpot " + parkingSpot + " has been allocated to Vehicle " + vehicle);

        return parkingTicket;
    }

    private ParkingSpot findFreeParkingSpot(VehicleType vehicleType, List<ParkingSpot> parkingSpots) {
        for (ParkingSpot spot : parkingSpots) {
            if (isSpotEligible(vehicleType, spot)) {
                return spot;
            }
        }
        throw new NoParkingAvailableException("No parking is currently available for. Sorry!");
    }

    private boolean isSpotEligible(VehicleType vehicleType, ParkingSpot spot) {
        return spot.isSpotFree() && vehicleType.name().equals(spot.getParkingSpotType().name());
    }

}
