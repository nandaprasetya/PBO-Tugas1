package Routes;

import View.AdminView;
import View.UserView;
import Securities.SBNs;
import Securities.Stocks;

import java.util.Scanner;

public class Routes {

    public static void userRoutes() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            UserView.userMainMenu();
            running = false;
        }
    }

    public static void adminRoutes() {
        Scanner scanner = new Scanner(System.in);
        handleAdmin(scanner);
    }

    public static void handleAdmin(Scanner scanner) {
        int choice;
        do {
            AdminView.adminMainMenu();
            System.out.print("Masukkan pilihan Anda: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.next();
                System.out.print("Masukkan pilihan Anda: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleStockMenu(scanner);
                    break;
                case 0:
                    System.out.println();
                    System.out.println("||==================================================================||");
                    System.out.println("||                       LOGOUT BERHASIL!                           ||");
                    System.out.println("||             Terima kasih telah menggunakan INVESTIA              ||");
                    System.out.println("||              Sampai jumpa dan selamat berinvestasi!              ||");
                    System.out.println("||==================================================================||");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 0);
    }

    public static void handleStockMenu(Scanner scanner) {
        int choice;
        do {
            AdminView.showStockMenu();
            System.out.print("Masukkan pilihan Anda (Saham): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.next();
                System.out.print("Masukkan pilihan Anda (Saham): ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Stocks.addStock(scanner);
                    AdminView.adminMainMenu();
                    System.out.println("Tekan Enter untuk kembali ke Menu Saham...");
                    scanner.nextLine();
                    break;
                case 2:
                    Stocks.updateStockPrice(scanner);
                    AdminView.adminMainMenu();
                    break;
                case 0:
                    System.out.println("Kembali ke Menu Admin...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 0);
    }

    public static void handleSBNMenu(Scanner scanner) {
        int choice;
        do {
            AdminView.showSBNMenu();
            System.out.print("Masukkan pilihan Anda (SBN): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.next();
                System.out.print("Masukkan pilihan Anda (SBN): ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    SBNs.addSBN(scanner);
                    break;
                case 2:
                    SBNs.viewSBNList();
                    break;
                case 3:
                    SBNs.deleteSBN(scanner);
                    break;
                case 0:
                    System.out.println("Kembali ke Menu Admin...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 0);
    }
}
