package Account;

import Utils.UserMainUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    private List<Accounts> users = new ArrayList<>();

    public Login() {

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

    public static Accounts viewLogin(Scanner scanner, ArrayList<Accounts> allUsers) {
        System.out.println("||==================================================================||");
        System.out.println("||                      WELCOME INVESTIA                            ||");
        System.out.println("||                   AYO INVESTASI SEKARANG!!                       ||");
        System.out.println("||==================================================================||");
        System.out.println("||      Mohon masukkan Username dan Password untuk melanjutkan      ||");
        System.out.println("||==================================================================||");
        System.out.print("|| USERNAME : ");
        String username = scanner.nextLine();
        System.out.print("|| PASSWORD : ");
        String password = scanner.nextLine();
        System.out.println();

        for (Accounts acc : allUsers) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)) {
                Session.setCurrentUser(acc);
                System.out.println("||==================================================================||");
                System.out.println("||          LOGIN BERHASIL! SELAMAT DATANG " + username.toUpperCase() + UserMainUtils.paddingText(25, username) + "||");
                System.out.println("||==================================================================||");
                return acc; // langsung return begitu ketemu akun
            }
        }

        UserMainUtils.clearScreen();
        System.out.println("||==================================================================||");
        System.out.println("||                USERNAME ATAU PASSWORD SALAH! COBA LAGI           ||");
        System.out.println("||==================================================================||");
        return null;
    }


}