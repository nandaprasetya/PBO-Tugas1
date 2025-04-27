import Routes.Routes;
import Account.Login;
import Account.Accounts;
import Account.Session;
import Account.Users;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        int choice;

        System.out.println("||==================================================================||");
        System.out.println("||                             INVESTIA                             ||");
        System.out.println("||==================================================================||");
        System.out.println("||                     AYO INVESTASI SEKARANG!!                     ||");
        System.out.println("||                                                                  ||");
        System.out.print("|| USERNAME : ");
        String username = scanner.nextLine();
        System.out.print("|| PASSWORD : ");
        String password = scanner.nextLine();
        System.out.println("||==================================================================||");
        System.out.println("||                       [0] UNTUK LOG OUT                          ||");
        System.out.println("||==================================================================||");

        Accounts user = login.login(username, password);
        Accounts loggedInAccount = Session.getCurrentUser();

        if (loggedInAccount instanceof Users) {
            Routes.userRoutes();
        }
        scanner.close();

    }
}