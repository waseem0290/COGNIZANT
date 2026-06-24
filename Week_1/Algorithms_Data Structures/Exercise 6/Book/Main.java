import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Book[] catalog = {
            new Book("B04", "Databases", "Raghu Ramakrishnan"),
            new Book("B01", "Algorithms", "Thomas Cormen"),
            new Book("B05", "Economics", "Paul Krugman"),
            new Book("B03", "Calculus", "James Stewart"),
            new Book("B02", "Bioinformatics", "Rosalind Franklin")
        };

        System.out.println("--- Testing Linear Search ---");
        Book book1 = Library.linearSearchByTitle(catalog, "Calculus");
        System.out.println("Result: " + (book1 != null ? book1 : "Book not found"));

        System.out.println("\n--- Preparing for Binary Search ---");
        Arrays.sort(catalog, Comparator.comparing(book -> book.title, String.CASE_INSENSITIVE_ORDER));
        
        System.out.println("Sorted Catalog:");
        for (Book b : catalog) System.out.println("  " + b.title);

        System.out.println("\n--- Testing Binary Search ---");
        Book book2 = Library.binarySearchByTitle(catalog, "Economics");
        System.out.println("Result: " + (book2 != null ? book2 : "Book not found"));
    }
}