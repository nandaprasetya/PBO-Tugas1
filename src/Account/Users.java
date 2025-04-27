package Account;

import Portofolio.PortfolioItem;
import Securities.Securities;

import java.util.ArrayList;
import java.util.List;

public class Users extends Accounts{
    private double balance;
    private ArrayList<PortfolioItem> portfolio;
    private static List<String> watchlist = new ArrayList<>();

    public Users(String id, String username, String password, String email, String role, double balance, ArrayList<PortfolioItem> portfolio) {
        super(id, username, password, email, "USER");
        this.balance = balance;
        this.portfolio = (portfolio != null) ? portfolio : new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public static List<String> getWatchlist() {
        return watchlist;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addToPortfolio(Securities securities, int quantity, double price) {
        for (PortfolioItem item : portfolio) {
            if (item.getSecurities().getCode().equals(securities.getCode())) {
                item.addQuantity(quantity);
                return;
            }
        }
        this.portfolio.add(new PortfolioItem(securities, quantity, price));
    }
}
