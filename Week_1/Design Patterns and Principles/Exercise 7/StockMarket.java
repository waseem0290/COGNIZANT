import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockSymbol;
    private double stockPrice;

    public StockMarket(String stockSymbol, double stockPrice) {
        this.observers = new ArrayList<>();
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockSymbol, stockPrice);
        }
    }

    public void setStockPrice(double newPrice) {
        this.stockPrice = newPrice;
        notifyObservers();
    }
}