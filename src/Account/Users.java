package Account;

import java.util.ArrayList;
import java.util.List;

public class Users extends Accounts{
    private double balance;
    private static List<String> watchlist = new ArrayList<>();

    public Users(String id, String username, String password, String email, String role, double balance) {
        super(id, username, password, email, "USER");
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public static List<String> getWatchlist() {
        return watchlist;
    }
}
