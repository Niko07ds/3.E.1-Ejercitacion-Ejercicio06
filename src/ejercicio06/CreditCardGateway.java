package ejercicio06;

/**
 * Producto concreto: tarjeta de crédito (recargo del 3 %).
 */
public class CreditCardGateway implements PaymentGateway {

    private static final double FEE_RATE = 0.03;

    @Override
    public Receipt charge(PurchaseOrder order) {
        double fee = order.getAmount() * FEE_RATE;
        return new Receipt(order.getOrderId(), getName(), order.getAmount(), fee);
    }

    @Override
    public double getMinimumAmount() {
        return 10.0;
    }

    @Override
    public String getName() {
        return "Tarjeta de crédito";
    }
}
