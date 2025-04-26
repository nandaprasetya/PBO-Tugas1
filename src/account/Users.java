package account;

public class Users extends Accounts{
    private double balance;

    public Users(String id, String username, String password, String email, String role, double balance) {
        super(id, username, password, email, "USER");
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
