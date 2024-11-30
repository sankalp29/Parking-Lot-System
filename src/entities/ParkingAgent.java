package entities;

import java.util.List;
import exceptions.NoParkingAvailableException;
import utilities.ParkingAllocationService;
import utilities.ParkingTicketManager;

public class ParkingAgent {
    private String name;
    private String id;

    private final ParkingAllocationService parkingAllocationService;
    private final ParkingTicketManager parkingTicketManager;

    public ParkingTicket allocateParking(Vehicle vehicle, List<ParkingSpot> parkingSpots)
            throws NoParkingAvailableException {

        return parkingAllocationService.allocateParking(vehicle, parkingSpots);
    }

    public void exitParking(Vehicle vehicle) {
        ParkingTicket parkingTicket = vehicle.getParkingTicket();
        parkingTicketManager.closeTicket(parkingTicket);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ParkingAgent(String name, String id) {
        this.name = name;
        this.id = id;
        this.parkingAllocationService = new ParkingAllocationService();
        this.parkingTicketManager = new ParkingTicketManager();
    }

}
