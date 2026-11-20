package ejercicio06;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Factoría de métodos de pago ");

        PaymentCreatorSelector selector = new PaymentCreatorSelector();

        List<PurchaseOrder> orders = Arrays.asList(
                new PurchaseOrder("ORD-001", "Ana", 250.00, PaymentMethod.CREDIT_CARD),
                new PurchaseOrder("ORD-002", "Bruno", 1200.00, PaymentMethod.BANK_TRANSFER),
                new PurchaseOrder("ORD-003", "Carla", 80.00, PaymentMethod.DIGITAL_WALLET),
                new PurchaseOrder("ORD-004", "Diego", 30.00, PaymentMethod.BANK_TRANSFER),
                new PurchaseOrder("ORD-005", "Elena", 8000.00, PaymentMethod.DIGITAL_WALLET));

        for (PurchaseOrder order : orders) {
            System.out.println("\n Orden " + order.getOrderId() + " (" + order.getCustomerName()
                    + ", $" + order.getAmount() + ", " + order.getPaymentMethod() + ") ---");
            try {
                PaymentCreator creator = selector.select(order);
                Receipt receipt = creator.processPayment(order);
                receipt.print();
            } catch (InvalidPaymentException e) {
                System.out.println("  Pago rechazado: " + e.getMessage());
            }
        }
    }
}
