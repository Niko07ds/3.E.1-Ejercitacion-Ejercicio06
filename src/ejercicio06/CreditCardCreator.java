package ejercicio06;

public class CreditCardCreator extends PaymentCreator {

    @Override
    protected PaymentGateway createGateway() {
        return new CreditCardGateway();
    }
}
