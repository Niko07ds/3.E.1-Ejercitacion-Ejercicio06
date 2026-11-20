package ejercicio06;

/**
 * Producto concreto: transferencia bancaria (comisión fija de $2,50).
 */
public class BankTransferGateway implements PaymentGateway {

    private static final double FIXED_FEE = 2.50;

    @Override
    public Receipt charge(PurchaseOrder order) {
        return new Receipt(order.getOrderId(), getName(), order.getAmount(), FIXED_FEE);
    }

    @Override
    public double getMinimumAmount() {
        return 50.0;
    }

    @Override
    public String getName() {
        return "Transferencia bancaria";
    }
}
