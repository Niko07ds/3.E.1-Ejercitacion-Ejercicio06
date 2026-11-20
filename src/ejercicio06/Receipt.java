package ejercicio06;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Comprobante de transacción devuelto por cada pasarela.
 */
public class Receipt {

    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final String transactionId;
    private final String orderId;
    private final String gatewayName;
    private final double baseAmount;
    private final double fee;

    public Receipt(String orderId, String gatewayName, double baseAmount, double fee) {
        this.transactionId = String.format("TX-%04d", COUNTER.incrementAndGet());
        this.orderId = orderId;
        this.gatewayName = gatewayName;
        this.baseAmount = baseAmount;
        this.fee = fee;
    }

    public double getTotal() {
        return baseAmount + fee;
    }

    public void print() {
        System.out.println("  Comprobante " + transactionId + " | Orden: " + orderId);
        System.out.println("  Medio: " + gatewayName);
        System.out.println(String.format("  Monto: $%.2f | Comisión: $%.2f | Total cobrado: $%.2f",
                baseAmount, fee, getTotal()));
    }
}
