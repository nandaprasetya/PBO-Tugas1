package Controllers;

import View.AdminView;
import java.util.Scanner;

public class AdminController {

    public static void start(Scanner scanner) {
        handleAdmin(scanner);
    }

    private static void handleAdmin(Scanner scanner) {
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
                case 0 -> logout();
                case 1 -> handleStockMenu(scanner);
                case 2 -> handleSBNMenu(scanner);
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 0);
    }

    private static void logout() {
        System.out.println("||==================================================================||");
        System.out.println("||                       LOGOUT BERHASIL!                           ||");
        System.out.println("||             Terima kasih telah menggunakan INVESTIA              ||");
        System.out.println("||              Sampai jumpa dan selamat berinvestasi!              ||");
        System.out.println("||==================================================================||");
    }

    private static void handleStockMenu(Scanner scanner) {
        int choice;
        do {
            AdminView.showStockMenu();
            System.out.print("Masukkan pilihan Anda: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.next();
                System.out.print("Masukkan pilihan Anda: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> AdminView.addStock(scanner);
                case 2 -> AdminView.updateStockPrice(scanner);
                case 3 -> AdminView.deleteStock(scanner);
                case 0 -> System.out.println("Kembali ke Main Menu Admin...");
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 0);
    }

    private static void handleSBNMenu(Scanner scanner) {
        int choice;
        do {
            AdminView.showSBNMenu();
            System.out.print("Masukkan pilihan Anda: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                scanner.next();
                System.out.print("Masukkan pilihan Anda: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> AdminView.addSBN(scanner);
                case 2 -> AdminView.viewSBNList();
                case 3 -> AdminView.deleteSBN(scanner);
                case 0 -> System.out.println("Kembali ke Main Menu Admin...");
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        } while (choice != 0);
    }
}
