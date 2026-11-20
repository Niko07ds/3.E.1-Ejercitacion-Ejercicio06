package ejercicio06;

/**
 * Producto: interfaz común de cobro de todas las pasarelas.
 */
public interface PaymentGateway {

    // Cobra la orden y devuelve el comprobante de la transacción
    Receipt charge(PurchaseOrder order);

    // Monto mínimo aceptado por la pasarela
    double getMinimumAmount();

    String getName();
}
