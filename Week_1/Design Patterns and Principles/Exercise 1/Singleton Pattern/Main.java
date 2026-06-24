public class Main {
    public static void main(String[] args) {
        Logger paymentLogger = Logger.getInstance();
        paymentLogger.log("Payment processed: $45.00");

        Logger inventoryLogger = Logger.getInstance();
        inventoryLogger.log("Inventory updated: Item shipped");

        System.out.println("Same instance? " + (paymentLogger == inventoryLogger));
    }
}