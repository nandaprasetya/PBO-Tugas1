package Securities;

import Data.SecuritiesData;

import java.util.ArrayList;
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
        System.out.print("Masukkan kode saham: ");
        String code = scanner.nextLine().trim();

        System.out.print("Masukkan nama perusahaan: ");
        String name = scanner.nextLine().trim();

        System.out.print("Masukkan harga awal saham: ");
        double firstPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Masukkan sektor saham: ");
        String sector = scanner.nextLine().trim();

        Stocks newStock = new Stocks(code, name, firstPrice, sector);
        SecuritiesData.getStocksList().add(newStock);

        System.out.println("Saham berhasil ditambahkan ke daftar!");
    }

    public static void updateStockPrice(Scanner scanner) {
        if (SecuritiesData.getStocksList().isEmpty()) {
            System.out.println("Tidak ada saham yang tersedia untuk diubah.");
            return;
        }

        System.out.println("Daftar Saham:");
        int no = 1;
        for (Stocks stock : SecuritiesData.getStocksList()) {
            System.out.printf("%d. %s - %s%n", no++, stock.getCode(), stock.getName());
        }

        System.out.print("Masukkan kode saham yang ingin diubah harganya: ");
        String code = scanner.nextLine().trim();

        Stocks found = null;
        for (Stocks stock : SecuritiesData.getStocksList()) {
            if (stock.getCode().equalsIgnoreCase(code)) {
                found = stock;
                break;
            }
        }

        if (found == null) {
            return;
        }

        System.out.print("Masukkan harga baru: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        found.getPriceHistory().add(newPrice);
        System.out.println("Harga saham berhasil diperbarui menjadi " + newPrice);
    }

    public static void deleteStock(Scanner scanner) {
        if (SecuritiesData.getStocksList().isEmpty()) {
            System.out.println("Tidak ada saham yang tersedia untuk dihapus.");
            return;
        }

        System.out.println("Daftar Saham:");
        int no = 1;
        for (Stocks stock : SecuritiesData.getStocksList()) {
            System.out.printf("%d. %s - %s%n", no++, stock.getCode(), stock.getName());
        }

        System.out.print("Masukkan kode saham yang ingin dihapus: ");
        String code = scanner.nextLine().trim();

        Stocks found = null;
        for (Stocks stock : SecuritiesData.getStocksList()) {
            if (stock.getCode().equalsIgnoreCase(code)) {
                found = stock;
                break;
            }
        }

        if (found != null) {
            SecuritiesData.getStocksList().remove(found);
            System.out.println("Saham berhasil dihapus!");
        }
    }
}
