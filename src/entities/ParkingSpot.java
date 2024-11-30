package entities;

import java.util.HashMap;

import enums.ParkingSpotType;
import enums.SpotStatus;
import exceptions.SpotAlreadyOccupiedException;
import exceptions.SpotAlreadyUnoccupiedException;

public class ParkingSpot {
    private final ParkingSpotType parkingSpotType;
    private SpotStatus spotStatus;
    private String spotId;
    private static HashMap<ParkingSpotType, Integer> spotIds;

    static {
        spotIds = new HashMap<>();
        for (ParkingSpotType spotType : ParkingSpotType.values()) {
            spotIds.put(spotType, 1);
        }
    }

    private static final String spotOccupiedExceptionMessage = "The spot is already occupied. Please choose and reserve a different spot";
    private static final String spotAlreadyUnoccupiedExceptionMessage = "The spot is already unoccupied.";

    public void reserveSpot() {
        if (spotStatus == SpotStatus.OCCUPIED)
            throw new SpotAlreadyOccupiedException(spotOccupiedExceptionMessage);
        this.spotStatus = SpotStatus.OCCUPIED;
    }

    public void freeUpSpot() {
        if (spotStatus == SpotStatus.FREE)
            throw new SpotAlreadyUnoccupiedException(spotAlreadyUnoccupiedExceptionMessage);

        this.spotStatus = SpotStatus.FREE;
    }

    public boolean isSpotFree() {
        return spotStatus == SpotStatus.FREE;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public SpotStatus getSpotStatus() {
        return spotStatus;
    }

    public ParkingSpot(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
        this.spotStatus = SpotStatus.FREE;
        this.spotId = parkingSpotType.name() + spotIds.get(parkingSpotType);
        spotIds.put(parkingSpotType, spotIds.get(parkingSpotType) + 1);
    }

    @Override
    public String toString() {
        return "ParkingSpot [parkingSpotType=" + parkingSpotType + ", spotStatus=" + spotStatus + ", spotId=" + spotId
                + "]";
    }

}
