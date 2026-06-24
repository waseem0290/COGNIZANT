import java.util.HashMap;
import java.util.Map;

class InventoryManager {
    private Map<String, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (inventory.containsKey(product.productId)) {
            System.out.println("Error: Product with ID " + product.productId + " already exists.");
            return;
        }
        inventory.put(product.productId, product);
        System.out.println("-> " + product.productName + " added successfully.");
    }

    public void updateProduct(String productId, int newQuantity, double newPrice) {
        if (!inventory.containsKey(productId)) {
            System.out.println("Error: Product not found.");
            return;
        }
        Product product = inventory.get(productId);
        product.quantity = newQuantity;
        product.price = newPrice;
        System.out.println("-> Product " + productId + " updated successfully.");
    }

    public void deleteProduct(String productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("-> Product " + productId + " removed successfully.");
        } else {
            System.out.println("Error: Product not found.");
        }
    }
}