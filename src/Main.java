import account.Login;
import account.Accounts;
import account.Users;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

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

        scanner.close();

    }
}