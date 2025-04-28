import Routes.Routes;
import Account.Login;
import Account.Accounts;
import Account.Session;
import Account.Users;
import Account.Admin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("||==================================================================||");
        System.out.println("||                      WELCOME INVESTIA                            ||");
        System.out.println("||                   AYO INVESTASI SEKARANG!!                       ||");
        System.out.println("||==================================================================||");
        System.out.println();
        System.out.println("||      Mohon masukkan Username dan Password untuk melanjutkan      ||");
        System.out.println("||------------------------------------------------------------------||");
        System.out.print("|| USERNAME : ");
        String username = scanner.nextLine();
        System.out.print("|| PASSWORD : ");
        String password = scanner.nextLine();
        System.out.println();

        Accounts user = login.login(username, password);
        Accounts loggedInAccount = Session.getCurrentUser();

        if (user == null) {
            Routes.loginFailedView();
        } else {
            if (user instanceof Users) {
                Routes.userRoutes((Users) user);
            } else if (user instanceof Admin) {
                Routes.adminRoutes();
            }
        }
        scanner.close();
    }
}
