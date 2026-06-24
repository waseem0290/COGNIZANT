public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Inventory System");
        
        InventoryManager manager = new InventoryManager();

        Product p1 = new Product("P001", "Gaming Laptop", 50, 1200.00);
        Product p2 = new Product("P002", "Wireless Mouse", 200, 25.50);
        Product p3 = new Product("P003", "Mechanical Keyboard", 100, 85.00);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        manager.updateProduct("P001", 45, 1150.00);

        manager.deleteProduct("P002");
        
        System.out.println("System Closed");
    }
}