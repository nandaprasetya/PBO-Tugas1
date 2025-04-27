package Controllers;

import Account.Accounts;
import Account.Session;
import Account.Users;
import Data.SecuritiesData;
import Routes.Routes;
import Securities.SBNs;
import Securities.Stocks;
import Utils.MainUtils;
import View.UserView;
import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserController {
    static Scanner scanner = new Scanner(System.in);
    public static List<String> getLimitedWatchlist(List<String> watchlist, int maxItems) {
        if (watchlist.size() > maxItems) {
            return new ArrayList<>(watchlist.subList(0, maxItems));
        }
        return new ArrayList<>(watchlist);
    }

    public static List<String> listWatchlist(){
        List<String> listWatchlist = new ArrayList<>();
        List<String> watchlist = getLimitedWatchlist(Users.getWatchlist(), 8);
        int watchlistNumber = 1;

        for(String codeStocks : watchlist){
            for(Stocks stock : SecuritiesData.getStocksList()){
                if(stock.getCode().equalsIgnoreCase(codeStocks)){
                    double nowPrice;
                    double lastPrice;
                    if (stock.getPriceHistory().size() >= 2) {
                        lastPrice = stock.getPreviousPrice();
                        nowPrice = stock.getCurrentPrice();
                    } else {
                        lastPrice = stock.getPrice();
                        nowPrice = stock.getPrice();
                    }

                    String codeText = watchlist.get(watchlistNumber - 1) + "   ||";
                    String nowPriceStr = String.valueOf((int) nowPrice);
                    String pricePadding = MainUtils.paddingText(9, nowPriceStr);
                    String priceText = " " + (int) nowPrice + pricePadding + "||";

                    String fullChangeText = (nowPrice - lastPrice) > 0 ? "+" + (int) (nowPrice - lastPrice) + "(" + stock.getPriceChangePercentage() + "%)" : (int) (nowPrice - lastPrice) + "(" + stock.getPriceChangePercentage() + "%)";
                    String paddingPercentage = MainUtils.paddingText(19, fullChangeText);
                    String percentageText = " " + fullChangeText + paddingPercentage + "||";
                    String paddingSector = MainUtils.paddingText(14, stock.getSector());
                    String sectorText = " " + stock.getSector() + paddingSector + "||";
                    String fullLineStock = " " + watchlistNumber + "   || " + codeText + priceText + percentageText + sectorText;
                    watchlistNumber += 1;
                    listWatchlist.add(fullLineStock);
                }
            }
        }

        if(watchlist.isEmpty()){
                listWatchlist.add("                    WATCHLIST ANDA KOSONG                         ||");
            for(int i = 0; i < 7; i++){
                listWatchlist.add("                                                                  ||");
            }
        }else if(watchlist.size() < 8){
            for(int i = 0; i < 8 - watchlist.size(); i++){
                listWatchlist.add("                                                                  ||");
            }
        }

        return listWatchlist;
    }

    public static List<String> getlistStocks(){
        List<String> contentListStock = new ArrayList<>();
        int noStock = 1;
        for(Stocks stock : SecuritiesData.getStocksList()){
            String code = stock.getCode();
            double price = stock.getCurrentPrice();
            double priceChange = stock.getPriceChange();
            String pricePercentage = stock.getPriceChangePercentage();
            String sector = stock.getSector();

            String nowPriceStr = MainUtils.formatRupiah ((int) price);
            String pricePadding = MainUtils.paddingText(11, nowPriceStr);
            String priceText = " " + nowPriceStr + pricePadding + "||";

            String fullChangeText = priceChange > 0 ? "+" + (int) priceChange + "(" + pricePercentage + "%)" : (int) priceChange + "(" + pricePercentage + "%)";
            String paddingPercentage = MainUtils.paddingText(17, fullChangeText);
            String percentageText = " " + fullChangeText + paddingPercentage + "||";

            String paddingSector = MainUtils.paddingText(14, stock.getSector());
            String sectorText = " " + sector + paddingSector + "||";

            String fullLineStock = " " + noStock  + MainUtils.paddingText(4, String.valueOf(noStock)) + "|| " + " " + code + "  ||" + priceText + percentageText + sectorText;
            contentListStock.add(fullLineStock);
            noStock += 1;
        }
        int blankSpace = 8 - (contentListStock.size() % 8);
        for (int i = 0; i <= blankSpace; i++) {
            contentListStock.add("                                                                  ||");
        }
        return contentListStock;
    }

    public static int maxPageListStock(){
        List<String> contentListStock = UserController.getlistStocks();

        return contentListStock.size() / 8;
    }

    public static int maxPageListSbn(){
        List<String> contentListStock = UserController.getListSbns();

        return contentListStock.size() / 8;
    }

    public static List<String> getListSbns(){
        List<String> listSbn = new ArrayList<>();
        int noSbn = 1;
        for(SBNs sbn: SecuritiesData.getSbnsList()){
            double price = sbn.getPrice();
            int quota = sbn.getNationalQuota();
            String interestRate = String.format("%.2f", sbn.getInterestRate());
            LocalDate maturityDate = sbn.getMaturityDate();

            String pricePadding = MainUtils.paddingText(11, MainUtils.formatRupiah((int) price));
            String quotaPadding = MainUtils.paddingText(7, String.valueOf(quota));
            String interestRatePadding = MainUtils.paddingText(6, interestRate);
            String maturityDatePadding = MainUtils.paddingText(12, maturityDate.toString());

            String sbnText = " " + noSbn + MainUtils.paddingText(4, String.valueOf(noSbn)) +"|| " + sbn.getCode() + "   || " + MainUtils.formatRupiah ((int) price) + pricePadding + "|| " + quota + quotaPadding + "|| " + interestRate + "%" + interestRatePadding + "|| " + maturityDate + maturityDatePadding + "||";
            noSbn += 1;
            listSbn.add(sbnText);
        }
        int blankSpace = 8 - (listSbn.size() % 8);
        for (int i = 0; i <= blankSpace; i++) {
            listSbn.add("                                                                  ||");
        }
        return listSbn;
    }

    public static void buyStockSbn(Users user){
        boolean isStocks = false;
        boolean isSbn = false;
        boolean isLoop = false;
        do {
            MainUtils.clearScreen();
            UserView.viewBuy(user);
            if(isLoop == true){
                System.out.println("||=====================================================================================||");
                System.out.println("||                               KODE SAHAM/SBN SALAH                                  ||");
                System.out.println("||=====================================================================================||");
            }
            System.out.print("|| Kode Saham / Sbn : ");
            String stockCode = scanner.next();
            for(Stocks stock : SecuritiesData.stocksList){
                if (stock.getCode().equalsIgnoreCase(stockCode)) {
                    isStocks = true;
                    System.out.print("|| Jumlah Saham : ");
                    int quantity = scanner.nextInt();
                    double total = stock.getPrice() * quantity * 100;
                    if (user.getBalance() >= total) {
                        MainUtils.clearScreen();
                        user.setBalance(user.getBalance() - total);
                        user.addToPortfolio(stock, quantity, stock.getCurrentPrice());
                        for(int i = 5; i >= 1; i--) {
                            MainUtils.clearScreen();
                            System.out.println("||=====================================================================================||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||                               TRANSAKSI BERHASIL                                    ||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||=====================================================================================||");
                            System.out.println("|| Anda Membeli : " + stockCode + MainUtils.paddingText(69, stockCode) + "||");
                            System.out.println("|| Jumlah : " + quantity + " LOT" + MainUtils.paddingText(71, String.valueOf(quantity)) + "||");
                            System.out.println("|| Harga Per Lembar : Rp. " + MainUtils.formatRupiah((long) stock.getPrice()) + MainUtils.paddingText(61, MainUtils.formatRupiah((long) stock.getPrice())) + "||");
                            System.out.println("|| Total Pembayaran : Rp. " + MainUtils.formatRupiah((long) total) + MainUtils.paddingText(61, MainUtils.formatRupiah((long) total)) + "||");
                            System.out.println("||=====================================================================================||");
                            System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + MainUtils.paddingText(49, "i") + "||");
                            System.out.println("||=====================================================================================||");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Accounts loggedInAccount = Session.getCurrentUser();
                        Routes.userRoutes((Users) loggedInAccount);
                    }else{
                        for(int i = 5; i >= 1; i--) {
                            MainUtils.clearScreen();
                            System.out.println("||=====================================================================================||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||                          TRANSAKSI GAGAL, SALDO TIDAK CUKUP                         ||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||=====================================================================================||");
                            System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + MainUtils.paddingText(49, "i") + "||");
                            System.out.println("||=====================================================================================||");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Accounts loggedInAccount = Session.getCurrentUser();
                        Routes.userRoutes((Users) loggedInAccount);
                    }
                }
            }
            for(SBNs sbn : SecuritiesData.sbnsList){
                if (sbn.getCode().equalsIgnoreCase(stockCode)) {
                    isSbn = true;
                    int quantity;
                    System.out.print("|| Jumlah Sbn : ");
                    quantity = scanner.nextInt();
                    if (sbn.getNationalQuota() >= quantity) {
                        double total = sbn.getPrice() * quantity;
                        if (user.getBalance() >= total) {
                            sbn.reduceQuota(quantity);
                            user.setBalance(user.getBalance() - total);
                            user.addToPortfolio(sbn, quantity, sbn.getPrice());
                            for(int i = 5; i >= 1; i--) {
                                MainUtils.clearScreen();
                                System.out.println("||=====================================================================================||");
                                System.out.println("||                                                                                     ||");
                                System.out.println("||                               TRANSAKSI BERHASIL                                    ||");
                                System.out.println("||                                                                                     ||");
                                System.out.println("||=====================================================================================||");
                                System.out.println("|| Anda Membeli : " + stockCode + MainUtils.paddingText(69, stockCode) + "||");
                                System.out.println("|| Jumlah : " + quantity + " UNIT" + MainUtils.paddingText(70, String.valueOf(quantity)) + "||");
                                System.out.println("|| Harga Per Unit : Rp. " + MainUtils.formatRupiah((long) sbn.getPrice()) + MainUtils.paddingText(63, MainUtils.formatRupiah((long) sbn.getPrice())) + "||");
                                System.out.println("|| Total Pembayaran : Rp. " + MainUtils.formatRupiah((long) total) + MainUtils.paddingText(61, MainUtils.formatRupiah((long) total)) + "||");
                                System.out.println("||=====================================================================================||");
                                System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + MainUtils.paddingText(49, "i") + "||");
                                System.out.println("||=====================================================================================||");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            Accounts loggedInAccount = Session.getCurrentUser();
                            Routes.userRoutes((Users) loggedInAccount);
                        }else{
                            for(int i = 5; i >= 1; i--){
                                System.out.println("||=====================================================================================||");
                                System.out.println("||                                                                                     ||");
                                System.out.println("||                          TRANSAKSI GAGAL, SALDO TIDAK CUKUP                         ||");
                                System.out.println("||                                                                                     ||");
                                System.out.println("||=====================================================================================||");
                                System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM "+ i + MainUtils.paddingText(49, "i") +"||");
                                System.out.println("||=====================================================================================||");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            Accounts loggedInAccount = Session.getCurrentUser();
                            Routes.userRoutes((Users) loggedInAccount);
                        }
                    } else{
                        for(int i = 5; i >= 1; i--) {
                            MainUtils.clearScreen();
                            System.out.println("||=====================================================================================||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||                     TRANSAKSI GAGAL, MELEBIHI KUOTA NASIONAL                        ||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||=====================================================================================||");
                            System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM "+ i + MainUtils.paddingText(49, "i") +"||");
                            System.out.println("||=====================================================================================||");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Accounts loggedInAccount = Session.getCurrentUser();
                        Routes.userRoutes((Users) loggedInAccount);
                    }
                }
            }
            isLoop = true;
        }while (isStocks == false && isSbn == false);
    }
}
