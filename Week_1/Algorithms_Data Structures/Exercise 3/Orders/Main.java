public class Main {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order("ORD001", "Alice", 250.50),
            new Order("ORD002", "Bob", 15.00),
            new Order("ORD003", "Charlie", 999.99),
            new Order("ORD004", "Diana", 120.00),
            new Order("ORD005", "Eve", 450.75)
        };

        Order[] ordersForQuick = ordersForBubble.clone();

        System.out.println("--- BUBBLE SORT EXECUTION ---");
        OrderSorter.bubbleSort(ordersForBubble);
        for (Order o : ordersForBubble) {
            System.out.println(o);
        }

        System.out.println("\n--- QUICK SORT EXECUTION ---");
        OrderSorter.quickSort(ordersForQuick);
        for (Order o : ordersForQuick) {
            System.out.println(o);
        }
    }
}