package enums;

public enum ParkingSpotType {
    TWO_WHEELER(5),
    CAR(10),
    TEMPO(20),
    BUS(30),
    TRUCK(40);

    private final int costPerHour;

    ParkingSpotType(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    public int getCostPerHour() {
        return costPerHour;
    }

}
