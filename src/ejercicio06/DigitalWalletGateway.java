package ejercicio06;

/**
 * Producto concreto: monedero digital (recargo del 1,5 % y tope por operación).
 */
public class DigitalWalletGateway implements PaymentGateway {

    private static final double FEE_RATE = 0.015;
    private static final double MAX_AMOUNT = 5000.0;

    @Override
    public Receipt charge(PurchaseOrder order) {
        // Regla de validación propia del monedero
        if (order.getAmount() > MAX_AMOUNT) {
            throw new InvalidPaymentException(String.format(
                    "El monedero digital permite hasta $%.2f por operación.", MAX_AMOUNT));
        }
        double fee = order.getAmount() * FEE_RATE;
        return new Receipt(order.getOrderId(), getName(), order.getAmount(), fee);
    }

    @Override
    public double getMinimumAmount() {
        return 5.0;
    }

    @Override
    public String getName() {
        return "Monedero digital";
    }
}
