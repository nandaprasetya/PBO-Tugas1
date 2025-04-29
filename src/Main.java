import Controllers.AdminController;
import Routes.Routes;
import Account.Login;
import Account.Accounts;
import Account.Session;
import Account.Users;
import Account.Admin;
import Utils.UserMainUtils;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
static ArrayList<Accounts> allUsers = new ArrayList<>();
    public static void main(String[] args) {
        Users nanda = new Users("US1", "Nanda", "pass123", "nanda@unud.ac.id", "USER", 10000000000.0, null);
        allUsers.add(nanda);
        allUsers.add(new Admin("ADM1", "Admin Devi", "admin123", "devi@unud.ac.id","ADMIN"));
        Scanner scanner = new Scanner(System.in);
        while(true){
            Accounts user = Login.viewLogin(scanner, allUsers);

            if (user == null) {
                Routes.loginFailedView();
            } else {
                Session.setCurrentUser(user);

                if (user instanceof Users) {
                    Routes.userRoutes((Users) user);
                } else if (user instanceof Admin) {
                    Routes.startAdmin(scanner);
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