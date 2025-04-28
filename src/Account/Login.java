package Account;


import java.util.ArrayList;
import java.util.List;

public class Login {
    private List<Accounts> users = new ArrayList<>();

    public Login() {
        Users nanda = new Users("US1", "Nanda", "pass123", "nanda@unud.ac.id", "USER", 10000000000.0, null);
        nanda.getWatchlist().addAll(List.of("BBCA", "PWON", "BBRI", "BSDE"));
        users.add(nanda);
        users.add(new Admin("ADM1", "Admin Devi", "admin123", "devi@unud.ac.id","ADMIN"));
    }

    public Accounts login(String username, String password) {
        for (Accounts user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                Session.login(user);
                return user;
            }
        }
        System.out.println("Login gagal");
        return null;
    }
}
