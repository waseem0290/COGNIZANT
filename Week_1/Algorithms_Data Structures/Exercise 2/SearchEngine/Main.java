import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] inventory = {
            new Product("SKU105", "Running Shoes", "Apparel"),
            new Product("SKU002", "Coffee Maker", "Home"),
            new Product("SKU899", "Smartphone", "Electronics"),
            new Product("SKU430", "Desk Lamp", "Home"),
            new Product("SKU050", "Blender", "Kitchen")
        };

        System.out.println("--- Linear Search ---");
        // Linear search doesn't care about order.
        Product foundLinear = SearchEngine.linearSearch(inventory, "SKU899");
        System.out.println("Found: " + foundLinear);

        System.out.println("\n--- Binary Search ---");
        // Binary search STRICTLY requires the array to be sorted by the search key first!
        Arrays.sort(inventory, Comparator.comparing(p -> p.productId));
        
        Product foundBinary = SearchEngine.binarySearch(inventory, "SKU050");
        System.out.println("Found: " + foundBinary);
    }
}