package Account;


import java.util.ArrayList;
import java.util.List;

public class Login {
    private List<Accounts> users = new ArrayList<>();

    public Login() {
        Users nanda = new Users("US1", "Nanda", "pass123", "nanda@unud.ac.id", "USER", 10000000000.0);
        nanda.getWatchlist().addAll(List.of("BBCA", "PWON", "BBRI", "BSDE", "JSMR", "PTPP", "BMRI", "SMGR", "WIKA"));
        users.add(nanda);
        users.add(new Admin("ADM1", "Admin Devi", "admin123", "devi@unud.ac.id"));
    }

    public Accounts login(String username, String password) {
        for (Accounts user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                Session.login(user);
                return user;
            }
        }
        return null;
    }
}
