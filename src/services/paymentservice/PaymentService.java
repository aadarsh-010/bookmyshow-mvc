package services.paymentservice;

public class PaymentService {
    private PaymentInterface pi;

    public void setPaymentStrategy(PaymentInterface pi) {
        this.pi = pi;
    }

    public void pay(int amount) {
        pi.pay(amount);
    }
}
