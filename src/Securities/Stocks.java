package Securities;

import Data.SecuritiesData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stocks extends Securities {
    private ArrayList<Double> priceHistory;
    private String sector;

    public Stocks(String code, String name, double firstPrice, String sector) {
        super(code, name, firstPrice);
        this.priceHistory = new ArrayList<>();
        this.priceHistory.add(firstPrice);
        this.sector = sector;
    }

    public ArrayList<Double> getPriceHistory() {
        return priceHistory;
    }

    public String getSector() {
        return sector;
    }

    public double getPreviousPrice() {
        if (priceHistory.size() < 2) {
            return price;
        }
        return priceHistory.get(priceHistory.size() - 2);
    }

    public double getCurrentPrice() {
        if (!priceHistory.isEmpty()) {
            return priceHistory.get(priceHistory.size() - 1);
        }
        return price;
    }

    public double getPriceChangePercentage() {
        if (getPreviousPrice() == 0) return 0;
        double change = (getCurrentPrice() - getPreviousPrice()) / getPreviousPrice() * 100;
        return change;
    }

    public static void addStock(Scanner scanner) {
        System.out.println("||========================== TAMBAH SAHAM ==========================||");

        String code;
        do {
            System.out.print("|| Masukkan kode saham       : ");
            code = scanner.nextLine().trim();
            if (code.isEmpty()) {
                System.out.println("|| Kode saham tidak boleh kosong!");
            }
        } while (code.isEmpty());

        String name;
        do {
            System.out.print("|| Masukkan nama perusahaan  : ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("|| Nama perusahaan tidak boleh kosong!");
            }
        } while (name.isEmpty());

        double firstPrice = -1;
        while (firstPrice <= 0) {
            System.out.print("|| Masukkan harga awal saham : ");
            if (scanner.hasNextDouble()) {
                firstPrice = scanner.nextDouble();
                if (firstPrice <= 0) {
                    System.out.println("|| Harga harus lebih dari 0!");
                }
            } else {
                System.out.print("|| Input tidak valid! Masukkan angka: ");
                scanner.next();
            }
        }
        scanner.nextLine();

        String sector;
        do {
            System.out.print("|| Masukkan sektor saham     : ");
            sector = scanner.nextLine().trim();
            if (sector.isEmpty()) {
                System.out.println("|| Sektor tidak boleh kosong!");
            }
        } while (sector.isEmpty());

        Stocks newStock = new Stocks(code, name, firstPrice, sector);
        SecuritiesData.getStocksList().add(newStock);

        System.out.println();
        System.out.println("||==================================================================||");
        System.out.println("||            Saham berhasil ditambahkan ke daftar!                 ||");
        System.out.println("||==================================================================||");
        System.out.println();
    }

    public static void updateStockPrice(Scanner scanner) {
        System.out.println("||========================= UBAH HARGA SAHAM ===========================||");

        if (SecuritiesData.getStocksList().isEmpty()) {
            System.out.println("|| Tidak ada saham yang tersedia untuk diubah.                         ||");
            System.out.println("||=====================================================================||");
            return;
        }

        System.out.println("|| Daftar Saham:                                                        ||");
        int no = 1;
        for (Stocks stock : SecuritiesData.getStocksList()) {
            String sahamInfo = no++ + ". " + stock.getCode() + " - " + stock.getName();
            System.out.printf("|| %-68s ||%n", sahamInfo);
        }
        System.out.println("||======================================================================||");

        Stocks found = null;
        do {
            System.out.print("|| Masukkan kode saham yang ingin diubah harganya: ");
            String code = scanner.nextLine().trim();
            for (Stocks stock : SecuritiesData.getStocksList()) {
                if (stock.getCode().equalsIgnoreCase(code)) {
                    found = stock;
                    break;
                }
            }
            if (found == null) {
                System.out.println("|| Kode saham tidak ditemukan, coba lagi!                               ||");
            }
        } while (found == null);

        double newPrice = -1;
        while (newPrice <= 0) {
            System.out.print("|| Masukkan harga baru: ");
            if (scanner.hasNextDouble()) {
                newPrice = scanner.nextDouble();
                if (newPrice <= 0) {
                    System.out.println("|| Harga harus lebih dari 0!                                            ||");
                }
            } else {
                System.out.println("|| Input tidak valid! Masukkan angka yang benar.                        ||");
                scanner.next();
            }
        }
        scanner.nextLine();

        found.getPriceHistory().add(newPrice);
        System.out.println();
        System.out.println("||======================================================================||");
        System.out.printf("|| Harga saham %-5s berhasil diperbarui menjadi %-10.2f             ||%n", found.getCode(), newPrice);
        System.out.println("||======================================================================||");

        String back;
        do {
            System.out.println("Tekan Enter untuk kembali ke Menu Saham...");
            back = scanner.nextLine();
        } while (!back.isEmpty());
    }

    public static void deleteStock(Scanner scanner) {
        System.out.println("||========================= HAPUS SAHAM ==============================||");

        if (SecuritiesData.getStocksList().isEmpty()) {
            System.out.println("|| Tidak ada saham yang tersedia untuk dihapus.                      ||");
            System.out.println("||===================================================================||");
            return;
        }

        System.out.println("|| Daftar Saham:                                                      ||");
        int no = 1;
        for (Stocks stock : SecuritiesData.getStocksList()) {
            String sahamInfo = no++ + ". " + stock.getCode() + " - " + stock.getName();
            System.out.printf("|| %-66s ||%n", sahamInfo);
        }
        System.out.println("||====================================================================||");

        Stocks found = null;
        do {
            System.out.print("|| Masukkan kode saham yang ingin dihapus: ");
            String code = scanner.nextLine().trim();
            for (Stocks stock : SecuritiesData.getStocksList()) {
                if (stock.getCode().equalsIgnoreCase(code)) {
                    found = stock;
                    break;
                }
            }
            if (found == null) {
                System.out.println("|| Kode saham tidak ditemukan, coba lagi!                             ||");
            }
        } while (found == null);

        String confirm;
        do {
            System.out.print("|| Yakin ingin menghapus saham ini? (Ya/Tidak): ");
            confirm = scanner.nextLine().trim();
            if (!confirm.equalsIgnoreCase("Ya") && !confirm.equalsIgnoreCase("Tidak")) {
                System.out.println("|| Input tidak valid! Ketik 'Ya' atau 'Tidak'.                        ||");
            }
        } while (!confirm.equalsIgnoreCase("Ya") && !confirm.equalsIgnoreCase("Tidak"));

        if (confirm.equalsIgnoreCase("Ya")) {
            SecuritiesData.getStocksList().remove(found);
            System.out.println("||====================================================================||");
            String successMessage = "Saham " + found.getName() + " berhasil dihapus!";
            System.out.printf("|| %-66s ||%n", successMessage);
            System.out.println("||====================================================================||");
        } else {
            System.out.println("||====================================================================||");
            System.out.println("|| Penghapusan dibatalkan.                                            ||");
            System.out.println("||====================================================================||");
        }

        String back;
        do {
            System.out.print("Tekan Enter untuk kembali ke Menu Saham...");
            back = scanner.nextLine();
        } while (!back.isEmpty());
    }
}