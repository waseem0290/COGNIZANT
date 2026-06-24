import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Executing Financial Forecast ---");

        int targetMonth = 40; 

        System.out.println("\nRunning Optimized Algorithm...");
        long startTimeOpt = System.currentTimeMillis();
        
        long resultOpt = FinancialForecaster.predictOptimized(targetMonth, new HashMap<>());
        
        long endTimeOpt = System.currentTimeMillis();
        System.out.println("Forecast Month " + targetMonth + ": " + resultOpt + " users.");
        System.out.println("Time taken: " + (endTimeOpt - startTimeOpt) + " ms");


        System.out.println("\nRunning Naive Algorithm...");
        long startTimeNaive = System.currentTimeMillis();
        
        long resultNaive = FinancialForecaster.predictNaive(targetMonth);
        
        long endTimeNaive = System.currentTimeMillis();
        System.out.println("Forecast Month " + targetMonth + ": " + resultNaive + " users.");
        System.out.println("Time taken: " + (endTimeNaive - startTimeNaive) + " ms");
    }
}