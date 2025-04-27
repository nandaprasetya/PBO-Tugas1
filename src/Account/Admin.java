package Account;

public class Admin extends Accounts{
    public Admin(String id, String username, String password, String email, String role) {
        super(id, username, password, email, "ADMIN");
    }
}
