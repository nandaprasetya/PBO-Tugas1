package View;

import Data.SecuritiesData;
import Securities.SBNs;
import Securities.Stocks;
import java.time.LocalDate;
import java.util.List;
import Utils.AdminMainUtils;
import java.util.Scanner;
import static Account.Session.getCurrentUser;

public class AdminView {

    public static String[] listMainMenu() {
        return new String[] {
                "|| MAIN MENU ADMIN ||",
                "||                 ||",
                "|| [1] SAHAM       ||",
                "|| [2] SBN         ||",
                "|| [0] LOGOUT      ||",
                "||                 ||"
        };
    }

    public static void adminMainMenu() {
        String[] mainMenu = listMainMenu();
        List<Stocks> stocksList = SecuritiesData.getStocksList();
        String username = getCurrentUser().getUsername();
        String fullLine = String.format("%-68s||", "SELAMAT DATANG, " + username);

        System.out.println("||=================||====================================================================||");
        System.out.println("||                 ||" + fullLine);
        System.out.println("||                 ||=========================== LIST SAHAM =============================||");
        System.out.println("||                 ||  NO. || KODE   || HARGA    || PERSENTASE         || SEKTOR         ||");
        System.out.println("||                 ||======||========||==========||====================||================||");

        int no = 1;
        for (int i = 0; i < mainMenu.length || no <= stocksList.size(); i++, no++) {
            String kiri = (i < mainMenu.length) ? mainMenu[i] : "||                 ||";
            if (no <= stocksList.size()) {
                Stocks stock = stocksList.get(no - 1);
                double change = stock.getCurrentPrice() != 0
                        ? ((stock.getCurrentPrice() - stock.getPreviousPrice()) / stock.getPreviousPrice() * 100)
                        : 0;
                String formattedChange = String.format("%+.2f%%", change);
                System.out.printf("%s  %-3d || %-6s || %-8.0f || %-18s || %-14s ||%n",
                        kiri, no, stock.getCode(), stock.getCurrentPrice(), formattedChange, stock.getSector());
            } else {
                System.out.println(kiri + "                                                                ||");
            }
        }

        System.out.println("||=================||====================================================================||");
        System.out.println("||                 ||     INPUT NO UNTUK MELIHAT MENU ADMIN & KODE SAHAM UNTUK DETAIL    ||");
        System.out.println("||=================||====================================================================||");
    }

    public static void showStockMenu() {
        System.out.println("||========================= MENU SAHAM =============================||");
        System.out.println("|| [1] Tambah Saham                                                 ||");
        System.out.println("|| [2] Ubah Harga Saham                                             ||");
        System.out.println("|| [3] Hapus Saham                                                  ||");
        System.out.println("|| [0] Kembali                                                      ||");
        System.out.println("||==================================================================||");
    }

    public static void showSBNMenu() {
        System.out.println("||========================== MENU SBN ==============================||");
        System.out.println("|| [1] Tambah SBN                                                   ||");
        System.out.println("|| [2] Lihat Daftar SBN                                             ||");
        System.out.println("|| [3] Hapus SBN                                                    ||");
        System.out.println("|| [0] Kembali                                                      ||");
        System.out.println("||==================================================================||");
    }

    public static void addSBN(Scanner scanner) {
        System.out.println("||========================== TAMBAH SBN ============================||");

        System.out.print("Masukkan kode SBN: ");
        String code = scanner.nextLine().trim();

        System.out.print("Masukkan nama SBN: ");
        String name = scanner.nextLine().trim();

        double price = 0;
        while (true) {
            System.out.print("Masukkan harga: ");
            try { price = Double.parseDouble(scanner.nextLine().trim());
                if (price <= 0) {
                    System.out.println("Harga harus lebih dari 0.");
                    continue;
                } break;
            } catch (NumberFormatException e) {
                System.out.println("Input harga tidak valid. Masukkan angka yang benar.");
            }
        }

        int quota = 0;
        while (true) {
            System.out.print("Masukkan kuota nasional: ");
            try { quota = Integer.parseInt(scanner.nextLine().trim());
                if (quota <= 0) {
                    System.out.println("Kuota harus lebih dari 0.");
                    continue;
                } break;
            } catch (NumberFormatException e) {
                System.out.println("Input kuota tidak valid. Masukkan angka bulat yang benar.");
            }
        }

        double interest = 0;
        while (true) {
            System.out.print("Masukkan bunga (%): ");
            try { interest = Double.parseDouble(scanner.nextLine().trim());
                if (interest <= 0) {
                    System.out.println("Bunga harus lebih dari 0.");
                    continue;
                } break;
            } catch (NumberFormatException e) {
                System.out.println("Input bunga tidak valid. Masukkan angka yang benar.");
            }
        }

        int duration = 0;
        while (true) {
            System.out.print("Masukkan durasi (bulan): ");
            try { duration = Integer.parseInt(scanner.nextLine().trim());
                if (duration <= 0) {
                    System.out.println("Durasi harus lebih dari 0.");
                    continue;
                } break;
            } catch (NumberFormatException e) {
                System.out.println("Input durasi tidak valid. Masukkan angka bulat yang benar.");
            }
        }

        LocalDate maturityDate = null;
        while (true) {
            System.out.print("Masukkan tanggal jatuh tempo (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine().trim();
            try { maturityDate = LocalDate.parse(dateInput);
                break;
            } catch (Exception e) {
                System.out.println("Format tanggal salah! Gunakan format YYYY-MM-DD.");
            }
        }

        SBNs newSBN = new SBNs(code, name, price, quota, interest, duration, maturityDate);
        SecuritiesData.getSbnsList().add(newSBN);

        System.out.println("||===================================================================||");
        System.out.println("||                 SBN berhasil ditambahkan ke daftar!               ||");
        System.out.println("||===================================================================||");
        System.out.println();
    }

    public static void viewSBNList() {
        if (SecuritiesData.getSbnsList().isEmpty()) {
            System.out.println("||==================================================================||");
            System.out.println("||                  Belum ada SBN yang tersedia.                    ||");
            System.out.println("||==================================================================||");
            return;
        }

        System.out.println("||====||========||==============================||==============||=======||========||========||================||");
        System.out.println("|| NO || KODE   || NAMA                         || HARGA        || KUOTA || BUNGA  || DURASI || JATUH TEMPO    ||");
        System.out.println("||====||========||==============================||==============||=======||========||========||================||");

        int no = 1;
        for (SBNs sbn : SecuritiesData.getSbnsList()) {
            System.out.printf(
                    "|| %2d || %-5s || %-28s || %12.2f || %5d || %5.2f%% || %6d || %14s ||%n",
                    no++,
                    sbn.getCode(),
                    sbn.getName(),
                    sbn.getPrice(),
                    sbn.getNationalQuota(),
                    sbn.getInterestRate(),
                    sbn.getDurationInMonths(),
                    sbn.getMaturityDate()
            );
        }

        System.out.println("||====||========||==============================||==============||=======||========||========||================||");
    }

    public static void deleteSBN(Scanner scanner) {
        System.out.println("||========================= HAPUS SBN ===============================||");

        if (SecuritiesData.getSbnsList().isEmpty()) {
            System.out.println("|| Tidak ada SBN yang tersedia untuk dihapus.                        ||");
            System.out.println("||===================================================================||");
            return;
        }

        viewSBNList();

        System.out.print("Masukkan kode SBN yang ingin dihapus: ");
        String code = scanner.nextLine().trim();
        SBNs found = null;
        for (SBNs sbn : SecuritiesData.getSbnsList()) {
            if (sbn.getCode().equalsIgnoreCase(code)) {
                found = sbn;
                break;
            }
        }

        if (found != null) {
            SecuritiesData.getSbnsList().remove(found);
            System.out.println("||===================================================================||");
            System.out.println("||                 SBN berhasil dihapus!                             ||");
            System.out.println("||===================================================================||");
        } else {
            System.out.println("|| Kode SBN tidak ditemukan.                                         ||");
        }
    }

    public static void addStock(Scanner scanner) {
        System.out.println("||========================== TAMBAH SAHAM ==========================||");

        System.out.print("Masukkan kode saham: ");
        String code = scanner.nextLine().trim();
        System.out.print("Masukkan nama perusahaan: ");
        String name = scanner.nextLine().trim();
        System.out.print("Masukkan harga awal saham: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan sektor saham: ");
        String sector = scanner.nextLine().trim();

        Stocks newStock = new Stocks(code, name, price, sector);
        SecuritiesData.getStocksList().add(newStock);

        System.out.println("|| Saham berhasil ditambahkan ke daftar! ||");
    }

    public static void updateStockPrice(Scanner scanner) {
        System.out.println("||========================= UBAH HARGA SAHAM ===========================||");

        if (SecuritiesData.getStocksList().isEmpty()) {
            System.out.println("|| Tidak ada saham yang tersedia untuk diubah.                         ||");
            return;
        }

        System.out.print("Masukkan kode saham yang ingin diubah: ");
        String code = scanner.nextLine().trim();

        Stocks found = null;
        for (Stocks stock : SecuritiesData.getStocksList()) {
            if (stock.getCode().equalsIgnoreCase(code)) {
                found = stock;
                break;
            }
        }

        if (found == null) {
            System.out.println("|| Kode saham tidak ditemukan!                                         ||");
            return;
        }

        System.out.print("Masukkan harga baru: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        found.getPriceHistory().add(newPrice);

        System.out.println("|| Harga saham berhasil diperbarui!                                   ||");
    }

    public static void deleteStock(Scanner scanner) {
        System.out.println("||========================= HAPUS SAHAM ==============================||");

        if (SecuritiesData.getStocksList().isEmpty()) {
            System.out.println("|| Tidak ada saham untuk dihapus.                                      ||");
            return;
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
            System.out.println("|| Saham berhasil dihapus! ||");
        } else {
            System.out.println("|| Kode saham tidak ditemukan. ||");
        }
    }
}
