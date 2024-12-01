import entities.ParkingAgent;
import entities.ParkingLot;
import entities.ParkingSpot;
import entities.Vehicle;
import enums.ParkingSpotType;
import enums.VehicleType;
import utilities.payment.PaymentModeSelector;

public class App {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = new ParkingLot(new ParkingAgent("Sankalp", "1"));

        parkingLot.addParkingSpot(new ParkingSpot(ParkingSpotType.CAR));
        parkingLot.addParkingSpot(new ParkingSpot(ParkingSpotType.CAR));

        Vehicle vehicle1 = new Vehicle(VehicleType.CAR, "Vehicle1");
        Vehicle vehicle2 = new Vehicle(VehicleType.CAR, "Vehicle2");

        parkingLot.allocateParking(vehicle1);
        parkingLot.allocateParking(vehicle2);

        parkingLot.exitParking(vehicle1);

        System.out.println("*********VEHICLE 1 HAS EXITED***********");

        parkingLot.exitParking(vehicle2);

        PaymentModeSelector.closeScanner();
    }
}