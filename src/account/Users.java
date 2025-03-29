package account;

public class Users extends Accounts{
    private double saldo;

    public Users(String id, String username, String password, String email, String role, double saldo) {
        super(id, username, password, email, "USER");
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }
}
