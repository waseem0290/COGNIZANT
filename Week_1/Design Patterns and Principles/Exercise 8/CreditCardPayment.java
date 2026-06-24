public class CreditCardPayment implements PaymentStrategy {
    private String nameOnCard;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String nameOnCard, String cardNumber, String cvv, String expiryDate) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("$" + amount + " paid with Credit Card ending in " + cardNumber.substring(12));
    }
}