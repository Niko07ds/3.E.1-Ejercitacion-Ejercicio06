package ejercicio06;

public class DigitalWalletCreator extends PaymentCreator {

    @Override
    protected PaymentGateway createGateway() {
        return new DigitalWalletGateway();
    }
}
