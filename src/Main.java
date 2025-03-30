import account.Login;
import account.Accounts;
import account.Session;
import account.Users;
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

        if (user != null) {
            System.out.println("Selamat datang, " + user.getUsername());
            System.out.println("Testing Getter ID " + user.getId());
            System.out.println("Testing Get Role" + user.getRole());
        }

        if(user.getRole() == "USER"){
            Users loggedUser = (Users) user;
            System.out.println("Saldo Anda: Rp " + loggedUser.getSaldo());
        }

        choice = scanner.nextInt();
        if(choice == 0){
            Session.logout();
            System.out.println("Testing Logged out Sukses.");
        }
        scanner.close();

    }
}