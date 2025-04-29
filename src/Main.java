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
        while(true){
            Accounts user = Login.viewLogin(scanner);
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
            System.out.println("||==================================================================||");
            System.out.println("||  Apakah Anda ingin logout dan keluar aplikasi? (y/n)             ||");
            System.out.println("||==================================================================||");
            System.out.print("|| MASUKAN PILIHAN : ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("Terima kasih telah menggunakan Investia!");
                break;
            } else {
                Session.setCurrentUser(null);
                UserMainUtils.clearScreen();
            }
        }
        scanner.close();
    }
}
