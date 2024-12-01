package utilities.payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import interfaces.PaymentMode;

public class PaymentModeSelector {
    private static Map<Integer, PaymentMode> paymentModes;
    private static Scanner scanner;

    static {
        paymentModes = new HashMap<>();
        paymentModes.put(1, new CashPayment());
        paymentModes.put(2, new UPIPayment());
        paymentModes.put(3, new CardPayment());

        scanner = new Scanner(System.in);
    }

    public static PaymentMode selectPaymentMode() {
        for (Map.Entry<Integer, PaymentMode> entry : paymentModes.entrySet()) {
            System.out.println(
                    entry.getKey() + ". " + entry.getValue().getClass().getSimpleName().replace("Payment", ""));
        }
        while (true) {
            try {
                int selection = scanner.nextInt();

                if (paymentModes.containsKey(selection))
                    return paymentModes.get(selection);

                System.out.println("Invalid selection. Please choose a number between 1 and " + paymentModes.size());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
            }
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}
