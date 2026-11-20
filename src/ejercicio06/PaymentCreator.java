package ejercicio06;

/**
 * Creador abstracto: declara el método de fábrica y valida el monto mínimo
 * antes de entregar la pasarela.
 */
public abstract class PaymentCreator {

    // Método de fábrica
    protected abstract PaymentGateway createGateway();

    // Crea la pasarela y verifica que la orden cumpla el monto mínimo
    public final PaymentGateway createValidatedGateway(PurchaseOrder order) {
        PaymentGateway gateway = createGateway();
        if (order.getAmount() < gateway.getMinimumAmount()) {
            throw new InvalidPaymentException(String.format(
                    "El monto $%.2f es menor al mínimo de %s ($%.2f).",
                    order.getAmount(), gateway.getName(), gateway.getMinimumAmount()));
        }
        return gateway;
    }

    // Operación común: crear la pasarela validada y cobrar
    public Receipt processPayment(PurchaseOrder order) {
        return createValidatedGateway(order).charge(order);
    }
}
