package Account;

public class Session {
    private static Accounts currentUser;

    public static void login(Accounts user) {
        currentUser = user;
        System.out.println("Login berhasil: " + user.getUsername());
    }

    public static void logout() {
        if (currentUser != null) {
            currentUser = null;
        } else {
            System.out.println("Tidak ada user yang login.");
        }
    }

    public static Accounts getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Accounts user) {
        Session.currentUser = user;
    }
}
