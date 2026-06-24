public class WebApp implements Observer {
    private String dashboardId;

    public WebApp(String dashboardId) {
        this.dashboardId = dashboardId;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Web Dashboard [" + dashboardId + "] updated -> " + stockSymbol + ": $" + stockPrice);
    }
}