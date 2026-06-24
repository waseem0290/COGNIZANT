public class Main {
    public static void main(String[] args) {
        StripeGateway stripe = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        
        PayPalGateway payPal = new PayPalGateway();
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);

        System.out.println("--- Executing Transactions ---");
        stripeProcessor.processPayment(150.75);
        payPalProcessor.processPayment(89.99);
    }
}