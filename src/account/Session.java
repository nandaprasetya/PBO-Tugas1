package account;

public class Session {
    private static Accounts currentUser;

    public static void login(Accounts user) {
        currentUser = user;
        System.out.println("Login berhasil: " + user.getUsername());
    }


    public static Accounts getCurrentUser() {
        return currentUser;
    }
}
