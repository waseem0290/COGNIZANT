class Library {

    public static Book linearSearchByTitle(Book[] catalog, String targetTitle) {
        for (int i = 0; i < catalog.length; i++) {
            if (catalog[i].title.equalsIgnoreCase(targetTitle)) {
                return catalog[i]; 
            }
        }
        return null; 
    }

    public static Book binarySearchByTitle(Book[] catalog, String targetTitle) {
        int left = 0;
        int right = catalog.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int comparison = targetTitle.compareToIgnoreCase(catalog[mid].title);

            if (comparison == 0) {
                return catalog[mid]; 
            } else if (comparison < 0) {
                right = mid - 1; 
            } else {
                left = mid + 1;  
            }
        }
        return null; 
    }
}