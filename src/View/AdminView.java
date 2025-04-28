package View;

import Data.SecuritiesData;
import Securities.Stocks;
import Utils.MainUtils;

import static Account.Session.getCurrentUser;

import java.util.List;

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
        String baseText = " SELAMAT DATANG, " + username;
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
                double change = stock.getCurrentPrice() != 0 ?
                        ((stock.getCurrentPrice() - stock.getPreviousPrice()) / stock.getPreviousPrice() * 100) : 0;
                String formattedChange = String.format("%+.2f%%", change);

                System.out.printf("%s  %-3d || %-6s || %-8.0f || %-18s || %-14s ||%n",
                        kiri,
                        no,
                        stock.getCode(),
                        stock.getCurrentPrice(),
                        formattedChange,
                        stock.getSector());
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
}