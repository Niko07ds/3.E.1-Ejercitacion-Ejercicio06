package ejercicio06;

/**
 * Se lanza cuando una orden no cumple las reglas del medio de pago.
 */
public class InvalidPaymentException extends RuntimeException {

    public InvalidPaymentException(String message) {
        super(message);
    }
}
