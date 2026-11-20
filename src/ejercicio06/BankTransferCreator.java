package ejercicio06;

public class BankTransferCreator extends PaymentCreator {

    @Override
    protected PaymentGateway createGateway() {
        return new BankTransferGateway();
    }
}
