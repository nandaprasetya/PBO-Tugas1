package Account;

public class Session {
    private static Accounts currentUser;

    public static void login(Accounts user) {
        currentUser = user;
        System.out.println("Login berhasil: " + user.getUsername());
    }

    public static void logout() {
        if (currentUser != null) {
            System.out.println("Logout: " + currentUser.getUsername());
            currentUser = null;
        } else {
            System.out.println("Tidak ada user yang login.");
        }
    }

    public static Accounts getCurrentUser() {
        return currentUser;
    }
}
