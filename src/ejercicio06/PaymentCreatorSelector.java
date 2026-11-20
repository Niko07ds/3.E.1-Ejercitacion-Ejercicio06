package ejercicio06;

import java.util.EnumMap;
import java.util.Map;

/**
 * Elige el creador adecuado a partir de los datos de la orden de compra.
 */
public class PaymentCreatorSelector {

    private final Map<PaymentMethod, PaymentCreator> creators = new EnumMap<>(PaymentMethod.class);

    public PaymentCreatorSelector() {
        creators.put(PaymentMethod.CREDIT_CARD, new CreditCardCreator());
        creators.put(PaymentMethod.BANK_TRANSFER, new BankTransferCreator());
        creators.put(PaymentMethod.DIGITAL_WALLET, new DigitalWalletCreator());
    }

    public PaymentCreator select(PurchaseOrder order) {
        PaymentCreator creator = creators.get(order.getPaymentMethod());
        if (creator == null) {
            throw new InvalidPaymentException("Medio de pago no soportado: " + order.getPaymentMethod());
        }
        return creator;
    }
}
