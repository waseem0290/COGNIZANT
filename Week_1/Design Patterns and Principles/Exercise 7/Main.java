public class Main {
    public static void main(String[] args) {
        StockMarket techStock = new StockMarket("AAPL", 175.50);

        Observer iosApp = new MobileApp("iOS Investor App");
        Observer androidApp = new MobileApp("Android Tracker");
        Observer webDashboard = new WebApp("Live-Dash");

        techStock.register(iosApp);
        techStock.register(androidApp);
        techStock.register(webDashboard);

        System.out.println("--- Market Update 1 ---");
        techStock.setStockPrice(176.85);

        System.out.println("\n--- Web Dashboard Offline ---");
        techStock.deregister(webDashboard);

        System.out.println("\n--- Market Update 2 ---");
        techStock.setStockPrice(174.20);
    }
}