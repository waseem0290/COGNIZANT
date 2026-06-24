import java.util.Map;

class FinancialForecaster {

    public static long predictNaive(int month) {
        if (month == 0) return 10000; 
        if (month == 1) return 15000; 

        return predictNaive(month - 1) + predictNaive(month - 2);
    }

    public static long predictOptimized(int month, Map<Integer, Long> cache) {
        if (month == 0) return 10000;
        if (month == 1) return 15000;

        if (cache.containsKey(month)) {
            return cache.get(month); 
        }

        long result = predictOptimized(month - 1, cache) + predictOptimized(month - 2, cache);

        cache.put(month, result);
        
        return result;
    }
}