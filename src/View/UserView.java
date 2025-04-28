package View;

import Account.Accounts;
import Account.Session;
import Controllers.UserController;
import Routes.Routes;
import Account.Users;
import Utils.UserMainUtils;

import java.util.ArrayList;
import java.util.List;

import static Account.Session.getCurrentUser;

public class UserView {

    public static void lineInput(){
        System.out.print("|| MASUKAN KODE MENU : ");
    }

    public static String[] listMainMenu(){
        return new String[]{
                "||=================||",
                "|| MAIN MENU       ||",
                "||                 ||",
                "|| [1] LIST SAHAM  ||",
                "|| [2] LIST SBN    ||",
                "|| [3] BELI SAHAM  ||",
                "||     DAN SBN     ||",
                "|| [4] SALDO       ||",
                "|| [5] PORTOFOLIO  ||",
                "||     SBN         ||",
                "|| [6] PORTOFOLIO  ||",
                "||     SAHAM       ||",
                "|| [7] SIMULASI    ||",
                "||     SBN         ||",
                "|| [8] JUAL SAHAM  ||",
                "|| [9] TAMBAH/HAPUS||",
                "||     WATCHLIST   ||",
                "|| [0] LOGOUT      ||",
                "||=================||"
        };
    }

    public static void userMainMenu(){
        String[] mainMenu = listMainMenu();
        List<String> contentLandingPage = UserController.listWatchlist();

        String username = getCurrentUser().getUsername();
        String baseText = " SELAMAT DATANG, " + username;
        String fullLine = baseText + UserMainUtils.paddingText(66, baseText) + "||";

        int j = 0;
        for (int i = 0; i < mainMenu.length; i++){
            System.out.print(mainMenu[i]);
            if(i <= 7){
                if(i == 0){
                    System.out.print("==================================================================||");
                }else if(i == 1){
                    System.out.print(fullLine);
                }else if(i == 2){
                    System.out.print("                                                                  ||");
                }else if(i == 3){
                    System.out.print("==================================================================||");
                }else if(i == 4){
                    System.out.print(" LIST SAHAM :                                                     ||");
                }else if(i == 5){
                    System.out.print("==================================================================||");
                }else if(i == 6){
                    System.out.print(" NO. || KODE   || HARGA    || PERSENTASE         || SEKTOR        ||");
                }else {
                    System.out.print("=====||========||==========||====================||===============||");
                }
            }else{
                if (i < 16) {
                    System.out.print(contentLandingPage.get(j));
                }
                if (i == 16) {
                    System.out.print("==================================================================||");
                } else if (i == 17) {
                    System.out.print("               INPUT NO UNTUK MELIHAT MAIN MENU                   ||");
                } else if (i == 18) {
                    System.out.print("==================================================================||");
                }
                j += 1;
            }
            System.out.println();
        }
    }

    public static void viewListStock(int pageParam){
        String[] mainMenu = listMainMenu();
        List<String> contentListStock = UserController.getlistStocks();

        String baseText = "HAI "+ getCurrentUser().getUsername() +", MAU CARI SAHAM APA HARI INI ?";
        String fullLine = baseText + UserMainUtils.paddingText(66, baseText) + "||";
        int page = pageParam;
        if(page >= 1){
            int j = (page - 1) * 8;
            for (int i = 0; i < mainMenu.length; i++){
                System.out.print(mainMenu[i]);
                if(i <= 7){
                    if(i == 0){
                        System.out.print("==================================================================||");
                    }else if(i == 1){
                        System.out.print(fullLine);
                    }else if(i == 2){
                        System.out.print("                                                                  ||");
                    }else if(i == 3){
                        System.out.print("==================================================================||");
                    }else if(i == 4){
                        System.out.print(" LIST SAHAM :                                                     ||");
                    }else if(i == 5){
                        System.out.print("==================================================================||");
                    }else if(i == 6){
                        System.out.print(" NO. || KODE   || HARGA      || PERSENTASE       || SEKTOR        ||");
                    }else {
                        System.out.print("=====||========||============||==================||===============||");
                    }
                }else{
                    if (i < 16) {
                        System.out.print(contentListStock.get(j));
                    }
                    if (i == 16) {
                        System.out.print("==================================================================||");
                    } else if (i == 17) {
                        if(page == 1){
                            String lineText = " ["+ page + "/" + UserController.maxPageListStock() +"] [NEXT] SELANJUTNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) +"||");
                        }else if(page == UserController.maxPageListStock()){
                            String lineText = " ["+ page + "/" + UserController.maxPageListStock() +"] [PREV] SEBELUMNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        }else{
                            String lineText = " ["+ page + "/" + UserController.maxPageListStock() +"] [PREV] SEBELUMNYA | [NEXT] SELANJUTNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        }
                    } else if (i == 18) {
                        System.out.print("==================================================================||");
                    }
                    j += 1;
                }
                System.out.println();
            }
        }
    }

    public static void viewListSbn(int pageParam) {
        String[] mainMenu = listMainMenu();
        List<String> contentListSbn = UserController.getListSbns();
        String baseText = "HAI " + getCurrentUser().getUsername() + ", MAU CARI SBN APA HARI INI ?";
        String fullLine = baseText + UserMainUtils.paddingText(66, baseText) + "||";
        int page = pageParam;

        if (page >= 1) {
            int j = (page - 1) * 8;
            for (int i = 0; i < mainMenu.length; i++) {
                System.out.print(mainMenu[i]);
                if (i <= 7) {
                    if (i == 0) {
                        System.out.print("==================================================================||");
                    } else if (i == 1) {
                        System.out.print(fullLine);
                    } else if (i == 2) {
                        System.out.print("                                                                  ||");
                    } else if (i == 3) {
                        System.out.print("==================================================================||");
                    } else if (i == 4) {
                        System.out.print(" LIST SBN :                                                       ||");
                    } else if (i == 5) {
                        System.out.print("==================================================================||");
                    } else if (i == 6) {
                        System.out.print(" NO. || KODE     || HARGA      || KUOTA  || BUNGA  || JATUH TEMPO ||");
                    } else {
                        System.out.print("=====||==========||============||========||========||=============||");
                    }
                } else {
                    if (i < 16) {
                        System.out.print(contentListSbn.get(j));
                    }
                    if (i == 16) {
                        System.out.print("==================================================================||");
                    } else if (i == 17) {
                        if (page == 1) {
                            String lineText = " [" + page + "/" + UserController.maxPageListSbn() + "] [NEXT] SELANJUTNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        } else if (page == UserController.maxPageListSbn()) {
                            String lineText = " [" + page + "/" + UserController.maxPageListSbn() + "] [PREV] SEBELUMNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        } else {
                            String lineText = " [" + page + "/" + UserController.maxPageListSbn() + "] [PREV] SEBELUMNYA | [NEXT] SELANJUTNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        }
                    } else if (i == 18) {
                        System.out.print("==================================================================||");
                    }
                    j += 1;
                }
                System.out.println();
            }
        }
    }

    public static void viewBuy(Users user){
        System.out.println("||=====================================================================================||");
        System.out.println("|| Saldo Anda : Rp. " + UserMainUtils.formatRupiah((long) user.getBalance()) + UserMainUtils.paddingText(67, UserMainUtils.formatRupiah((long) user.getBalance())) + "||");
        System.out.println("||=====================================================================================||");
        System.out.println("|| Masukan Kode Saham / Sbn Dengan Benar                                               ||");
        System.out.println("||=====================================================================================||");
    }

    public static void viewBalance(Users user){
        String[] mainMenu = listMainMenu();
        List<String> contentBalance = new ArrayList<>();
        contentBalance.add("==================================================================||");
        contentBalance.add("                                                                  ||");
        contentBalance.add(" HALLO "+ getCurrentUser().getUsername() + UserMainUtils.paddingText(76, String.valueOf(Session.getCurrentUser())) +"||");
        contentBalance.add(" BERIKUT INFORMASI SALDO ANDA                                     ||");
        contentBalance.add("                                                                  ||");
        contentBalance.add("==================================================================||");
        contentBalance.add("                                                                  ||");
        contentBalance.add(" SALDO ANDA : Rp. "+ UserMainUtils.formatRupiah((long) user.getBalance()) + UserMainUtils.paddingText(48, UserMainUtils.formatRupiah((long) user.getBalance())) +"||");
        contentBalance.add("                                                                  ||");
        contentBalance.add("==================================================================||");
        contentBalance.add("                                                                  ||");
        contentBalance.add(" NILAI INVESTASI SAHAM : Rp. "+ UserMainUtils.formatRupiah(UserController.getStockBalance()) + UserMainUtils.paddingText(37, UserMainUtils.formatRupiah(UserController.getStockBalance())) +"||");
        contentBalance.add(" NILAI INVESTASI SBN   : Rp. "+ UserMainUtils.formatRupiah(UserController.getSbnBalance(user)) + UserMainUtils.paddingText(37, UserMainUtils.formatRupiah(UserController.getSbnBalance(user))) +"||");
        contentBalance.add("                                                                  ||");
        contentBalance.add("==================================================================||");
        contentBalance.add("                                                                  ||");
        contentBalance.add("             [11] TAMBAH SALDO   |   [12] TARIK SALDO             ||");
        contentBalance.add("                                                                  ||");
        contentBalance.add("==================================================================||");

        for(int i = 0; i < mainMenu.length; i++){
            System.out.println(mainMenu[i] + contentBalance.get(i));
        }
    }

    public static void viewSbnPortofolio(Users user, int pageParam){
        List<String> listSbn = UserController.listSbnPortofolio(user);
        String[] mainMenu = listMainMenu();

        String baseText = "HAI "+ getCurrentUser().getUsername() +", INI PORTOFOLIO MU";
        String fullLine = baseText + UserMainUtils.paddingText(66, baseText) + "||";
        int page = pageParam;
        if(page >= 1){
            int j = (page - 1) * 8;
            for (int i = 0; i < mainMenu.length; i++){
                System.out.print(mainMenu[i]);
                if(i <= 7){
                    if(i == 0){
                        System.out.print("==================================================================||");
                    }else if(i == 1){
                        System.out.print(fullLine);
                    }else if(i == 2){
                        System.out.print("                                                                  ||");
                    }else if(i == 3){
                        System.out.print("==================================================================||");
                    }else if(i == 4){
                        System.out.print(" PORTOFOLIO ANDA :                                                ||");
                    }else if(i == 5){
                        System.out.print("==================================================================||");
                    }else if(i == 6){
                        System.out.print(" NO. || KODE   || BUNGA/BULAN || JUMLAH  || BUNGA  || JATUH TEMPO ||");
                    }else {
                        System.out.print("=====||========||=============||=========||========||=============||");
                    }
                }else {
                    if (i < 16) {
                        System.out.print(listSbn.get(j));
                    }
                    if (i == 16) {
                        System.out.print("==================================================================||");
                    } else if (i == 17) {
                        if (UserController.maxPageListSbnPorto(user) == 0){
                            System.out.print(" PILIH MENU [3] UNTUK MEMBELI SBN                                 ||");
                        } else if(page == 1 && UserController.maxPageListSbnPorto(user) == 1){
                            String lineText = " [" + page + "/" + UserController.maxPageListSbnPorto(user) + "]";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        }
                        else if (page == 1) {
                            String lineText = " [" + page + "/" + UserController.maxPageListSbnPorto(user) + "] [NEXT] SELANJUTNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        } else if (page == UserController.maxPageListSbnPorto(user)) {
                            String lineText = " [" + page + "/" + UserController.maxPageListSbnPorto(user) + "] [PREV] SEBELUMNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        } else {
                            String lineText = " [" + page + "/" + UserController.maxPageListSbnPorto(user) + "] [PREV] SEBELUMNYA | [NEXT] SELANJUTNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        }
                    } else if (i == 18) {
                        System.out.print("==================================================================||");
                    }
                    j += 1;
                }
                System.out.println();
            }
        }
    }

    public static void viewStockPortofolio(Users user, int page){
        List<String> listStock = UserController.listStockPortofolio(user);
        String[] mainMenu = listMainMenu();

        String baseText = "HAI "+ getCurrentUser().getUsername() +", INI PORTOFOLIO MU";
        String fullLine = baseText + UserMainUtils.paddingText(66, baseText) + "||";
        if(page >= 1){
            int j = (page - 1) * 8;
            for (int i = 0; i < mainMenu.length; i++){
                System.out.print(mainMenu[i]);
                if(i <= 7){
                    if(i == 0){
                        System.out.print("==================================================================||");
                    }else if(i == 1){
                        System.out.print(fullLine);
                    }else if(i == 2){
                        System.out.print("                                                                  ||");
                    }else if(i == 3){
                        System.out.print("==================================================================||");
                    }else if(i == 4){
                        System.out.print(" PORTOFOLIO ANDA :                                                ||");
                    }else if(i == 5){
                        System.out.print("==================================================================||");
                    }else if(i == 6){
                        System.out.print(" NO || KODE   || NILAI BELI    || NILAI SEKARANG  || JUMLAH/LEMBAR||");
                    }else {
                        System.out.print("====||========||===============||=================||==============||");
                    }
                }else{
                    if (i < 16) {
                        System.out.print(listStock.get(j));
                    }
                    if (i == 16) {
                        System.out.print("==================================================================||");
                    } else if (i == 17) {
                        if (UserController.maxPageListStockPorto(user) == 0){
                            System.out.print(" PILIH MENU [3] UNTUK MEMBELI SAHAM                               ||");
                        } else if(page == 1 && UserController.maxPageListStockPorto(user) == 1){
                            String lineText = " [" + page + "/" + UserController.maxPageListStockPorto(user) + "]";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        }
                        else if (page == 1) {
                            String lineText = " [" + page + "/" + UserController.maxPageListStockPorto(user) + "] [NEXT] SELANJUTNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        } else if (page == UserController.maxPageListStockPorto(user)) {
                            String lineText = " [" + page + "/" + UserController.maxPageListStockPorto(user) + "] [PREV] SEBELUMNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        } else {
                            String lineText = " [" + page + "/" + UserController.maxPageListStockPorto(user) + "] [PREV] SEBELUMNYA | [NEXT] SELANJUTNYA";
                            System.out.print(lineText + UserMainUtils.paddingText(66, lineText) + "||");
                        }
                    } else if (i == 18) {
                        System.out.print("==================================================================||");
                    }
                    j += 1;
                }
                System.out.println();
            }
        }
    }

    public static void landingSimulationSbn(){
        System.out.println("||=====================================================================================||");
        System.out.println("||                                                                                     ||");
        System.out.println("||                     MASUKAN KODE SBN UNTUK SIMULASI                                 ||");
        System.out.println("||                                                                                     ||");
        System.out.println("||=====================================================================================||");
    }

    public static void viewSellStock(Users user){
        int page = 1;
        viewStockPortofolio(user, page);
        System.out.println("||                                                                                     ||");
        System.out.println("|| MASUKAN KODE SAHAM UNTUK MENJUAL                                                    ||");
        System.out.println("||=====================================================================================||");
        System.out.print("|| Masukan Kode : ");
    }

    public static void successSellStock(int remainingStocks, int totalSaleAmount, double sellPrice, double buyPrice, int lotQuantity){
        String[] mainMenu = listMainMenu();
        List<String> contentSuccessSell = new ArrayList<>();

        String baseText = "HAI "+ getCurrentUser().getUsername() +", TRANSAKSI PENJUALAN MU SUKSES";
        String fullLine = baseText + UserMainUtils.paddingText(66, baseText) + "||";
        contentSuccessSell.add("==================================================================||");
        contentSuccessSell.add("                                                                  ||");
        contentSuccessSell.add(fullLine);
        contentSuccessSell.add("                                                                  ||");
        contentSuccessSell.add("==================================================================||");
        contentSuccessSell.add("                                                                  ||");
        contentSuccessSell.add("SISA SAHAM : "+ remainingStocks + UserMainUtils.paddingText(53, String.valueOf(remainingStocks)) +"||");
        contentSuccessSell.add("------------------------------------------------------------------||");
        contentSuccessSell.add("SAHAM YANG DIJUAL : "+ lotQuantity + UserMainUtils.paddingText(46, String.valueOf(lotQuantity)) +"||");
        contentSuccessSell.add("------------------------------------------------------------------||");
        contentSuccessSell.add("HARGA BELI : Rp. "+ UserMainUtils.formatRupiah((long) buyPrice) + UserMainUtils.paddingText(49, UserMainUtils.formatRupiah((long) buyPrice)) +"||");
        contentSuccessSell.add("------------------------------------------------------------------||");
        contentSuccessSell.add("HARGA JUAL : Rp. "+ UserMainUtils.formatRupiah((long) sellPrice) + UserMainUtils.paddingText(49, UserMainUtils.formatRupiah((long) sellPrice)) +"||");
        contentSuccessSell.add("------------------------------------------------------------------||");
        contentSuccessSell.add("HASIL PENJUALAN : Rp. "+ UserMainUtils.formatRupiah(totalSaleAmount) + UserMainUtils.paddingText(44, UserMainUtils.formatRupiah(totalSaleAmount)) +"||");
        contentSuccessSell.add("                                                                  ||");
        contentSuccessSell.add("==================================================================||");
        contentSuccessSell.add("                 TERIMA KASIH SUDAH BERTRANSAKSI                  ||");
        contentSuccessSell.add("==================================================================||");

        UserMainUtils.clearScreen();
        for(int i = 0; i < mainMenu.length; i++){
            System.out.println(mainMenu[i] + contentSuccessSell.get(i));
        }
        System.out.println("||                 PESAN AKAN TERTUTUP OTOMATIS DALAM 3 DETIK                          ||");
        System.out.println("||=====================================================================================||");
        for(int i = 0; i < 3; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Accounts loggedInAccount = Session.getCurrentUser();
        Routes.userRoutes((Users) loggedInAccount);
    }

    public static void viewSimulationSbn(String code){
        String[] mainMenu = listMainMenu();
        List<String> contentSimulationSbn = UserController.SimulationSbn(code);

        for (int i = 0; i < mainMenu.length; i++){
            System.out.println(mainMenu[i] + contentSimulationSbn.get(i));
        }
    }

    public static void showUserMenu(){
        System.out.println("||=================||==================================================================||");
        System.out.println("|| MAIN MENU       ||                         SELAMAT DATANG                           ||");
        System.out.println("||                 ||                         NANDA PRASETYA                           ||");
        System.out.println("|| [1] LIST SAHAM  ||==================================================================||");
        System.out.println("|| [2] LIST SBN    || WATCHLIST ANDA                                                   ||");
        System.out.println("|| [3] CEK SALDO   ||==================================================================||");
        System.out.println("|| [4] ISI SALDO   || NO. || KODE   || HARGA    || PERSENTASE         || SEKTOR        ||");
        System.out.println("|| [5] TARIK       ||=====||========||==========||====================||===============||");
        System.out.println("||     SALDO       || 1   || BBCA   || 8500     || -25(-0.29%)        || FINANCE       ||");
        System.out.println("|| [6] AKUN ANDA   || 2   || BBRI   || 4050     || +50(+1.25%)        || FINANCE       ||");
        System.out.println("|| [7] LIHAT       || 3   || BMRI   || 5200     || +50(+0.97%)        || FINANCE       ||");
        System.out.println("||     PORTOFOLIO  || 4   || PANI   || 10000    || +900+(9.89%)       || PROPERTY      ||");
        System.out.println("|| [8] SIMULASI    || 5   || WIFI   || 1800     || +10(+0.56%)        || TECHNOLOGY    ||");
        System.out.println("||     SBN         || 6   || CBDK   || 5950     || +875(+17.24%)      || INFRASTRUC    ||");
        System.out.println("|| [9] JUAL SAHAM  || 7   || ASII   || 4920     || +120(+2.50%)       || INDUSTRIAL    ||");
        System.out.println("|| [0] LOGOUT      || 8   || BBNI   || 4240     || -10(-0.24%)        || FINANCE       ||");
        System.out.println("||                 ||==================================================================||");
        System.out.println("||                 ||     INPUT NO UNTUK MELIHAT MAIN MENU & KODE SAHAM UNTUK DETAIL   ||");
        System.out.println("||=================||==================================================================||");
    }
}
