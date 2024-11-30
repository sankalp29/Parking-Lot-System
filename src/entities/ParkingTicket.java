package entities;

import java.time.LocalDateTime;

public class ParkingTicket {
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime inTime;
    private LocalDateTime outTime;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.inTime = LocalDateTime.now();
    }

    public void setOutTime() {
        this.outTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ParkingTicket [vehicle=" + vehicle + ", parkingSpot=" + parkingSpot + ", inTime=" + inTime + "]";
    }

}
