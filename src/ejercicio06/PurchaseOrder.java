package ejercicio06;

/**
 * Orden de compra: de sus datos se deduce la pasarela a construir.
 */
public class PurchaseOrder {

    private final String orderId;
    private final String customerName;
    private final double amount;
    private final PaymentMethod paymentMethod;

    public PurchaseOrder(String orderId, String customerName, double amount, PaymentMethod paymentMethod) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
