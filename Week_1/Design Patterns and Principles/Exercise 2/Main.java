public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordFactory();
        DocumentFactory pdfFactory = new PdfFactory();
        DocumentFactory excelFactory = new ExcelFactory();

        System.out.println("--- Processing Word ---");
        wordFactory.processDocument();

        System.out.println("\n--- Processing PDF ---");
        pdfFactory.processDocument();

        System.out.println("\n--- Processing Excel ---");
        excelFactory.processDocument();
    }
}