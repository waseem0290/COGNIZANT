class SearchEngine {

    public static Product linearSearch(Product[] inventory, String targetId) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].productId.equals(targetId)) {
                return inventory[i]; 
            }
        }
        return null; 
    }

    public static Product binarySearch(Product[] inventory, String targetId) {
        int left = 0;
        int right = inventory.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = targetId.compareTo(inventory[mid].productId);

            if (comparison == 0) {
                return inventory[mid]; 
            } else if (comparison < 0) {
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }
        return null; 
    }
}