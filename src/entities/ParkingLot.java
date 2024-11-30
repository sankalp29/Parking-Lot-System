package entities;

import java.util.ArrayList;
import java.util.List;

import exceptions.NoParkingAvailableException;

public class ParkingLot {
    private ParkingAgent parkingAgent;
    private List<ParkingSpot> spots;

    public void allocateParking(Vehicle vehicle) {
        try {
            parkingAgent.allocateParking(vehicle, spots);
        } catch (NoParkingAvailableException exception) {
            System.out.println(exception.getMessage());
        }

    }

    public void exitParking(Vehicle vehicle) {
        parkingAgent.exitParking(vehicle);
    }

    public ParkingAgent getParkingAgent() {
        return parkingAgent;
    }

    public List<ParkingSpot> getSpots() {
        return spots;
    }

    public ParkingLot(ParkingAgent parkingAgent) {
        this.parkingAgent = parkingAgent;
        this.spots = new ArrayList<>();
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        spots.add(parkingSpot);
    }

}
