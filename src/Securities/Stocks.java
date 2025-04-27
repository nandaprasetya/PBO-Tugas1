package Securities;

import java.util.ArrayList;

public class Stocks extends Securities{
    private ArrayList<Double> priceHistory;
    private String sector;

    public Stocks(String code, String name, double firstPrice, String sector) {
        super(code, name, firstPrice);
        this.priceHistory = new ArrayList<>();
        this.priceHistory.add(firstPrice);
        this.sector = sector;
    }

    public ArrayList<Double> getPriceHistory() {
        return priceHistory;
    }

    public String getSector() {
        return sector;
    }

    public double getPreviousPrice() {
        if (priceHistory.size() < 2) return price;
        return priceHistory.get(priceHistory.size() - 2);
    }

    public double getCurrentPrice() {
        if (!priceHistory.isEmpty()) {
            return priceHistory.get(priceHistory.size() - 1);
        }
        return price;
    }

    public String getPriceChangePercentage() {
        if (getPreviousPrice() == 0) return "0";
        double change = (getCurrentPrice() - getPreviousPrice()) / getPreviousPrice() * 100;
        return String.format("%.2f%%", change);
    }
}
