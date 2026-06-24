public class Main {
    public static void main(String[] args) {
        PaymentContext checkout = new PaymentContext();

        PaymentStrategy creditCard = new CreditCardPayment("Alice Smith", "4111222233334444", "123", "12/26");
        checkout.setPaymentStrategy(creditCard);
        checkout.executePayment(150.00);

        PaymentStrategy payPal = new PayPalPayment("alice.smith@example.com", "superSecret123");
        checkout.setPaymentStrategy(payPal);
        checkout.executePayment(45.50);
    }
}