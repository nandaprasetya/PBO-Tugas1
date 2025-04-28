import Controllers.AdminController;
import Routes.Routes;
import Account.Login;
import Account.Accounts;
import Account.Session;
import Account.Users;
import Account.Admin;
import Utils.UserMainUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        Accounts user = null;

        while (true) {
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

            user = login.login(username, password);

            if (user != null) {
                System.out.println("||==================================================================||");
                System.out.println("||               LOGIN BERHASIL! SELAMAT DATANG " + username.toUpperCase() + "                 ||");
                System.out.println("||==================================================================||");
                break;
            } else {
                UserMainUtils.clearScreen();
                System.out.println("||==================================================================||");
                System.out.println("||                USERNAME ATAU PASSWORD SALAH! COBA LAGI           ||");
                System.out.println("||==================================================================||");
            }
        }
        Accounts loggedInAccount = Session.getCurrentUser();

        if (user == null) {
            Routes.loginFailedView();
        } else {
            if (user instanceof Users) {
                Routes.userRoutes((Users) user);
            } else if (user instanceof Admin) {
                AdminController.start(scanner);
            }
        }
        scanner.close();
    }
}
