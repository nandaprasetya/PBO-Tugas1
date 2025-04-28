package Portofolio;

import Securities.Securities;

public class PortfolioItem {
    private Securities securities;
    private int quantity;
    private double purchasePrice;

    public PortfolioItem(Securities securities, int quantity, double price) {
        this.securities = securities;
        this.quantity = quantity;
        this.purchasePrice = price;
    }

    public Securities getSecurities() {
        return securities;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void decreaseQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        }
    }
}
