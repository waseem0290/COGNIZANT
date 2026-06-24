class OrderSorter {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice < orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void quickSort(Order[] orders) {
        quickSortHelper(orders, 0, orders.length - 1);
    }

    private static void quickSortHelper(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);

            quickSortHelper(orders, low, pivotIndex - 1);
            quickSortHelper(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivotPrice = orders[high].totalPrice;
        int i = (low - 1); // Index of larger element

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice >= pivotPrice) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}