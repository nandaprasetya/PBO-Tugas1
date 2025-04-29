package Controllers;

import Account.Accounts;
import Account.Session;
import Account.Users;
import Data.SecuritiesData;
import Portfolio.PortfolioItem;
import Routes.Routes;
import Securities.SBNs;
import Securities.Securities;
import Securities.Stocks;
import Utils.UserMainUtils;
import View.UserView;
import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Account.Session.getCurrentUser;

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
                    String pricePadding = UserMainUtils.paddingText(9, nowPriceStr);
                    String priceText = " " + (int) nowPrice + pricePadding + "||";

                    String fullChangeText = (nowPrice - lastPrice) > 0 ? "+" + (int) (nowPrice - lastPrice) + "(" + stock.getPriceChangePercentage() + "%)" : (int) (nowPrice - lastPrice) + "(" + stock.getPriceChangePercentage() + "%)";
                    String paddingPercentage = UserMainUtils.paddingText(19, fullChangeText);
                    String percentageText = " " + fullChangeText + paddingPercentage + "||";
                    String paddingSector = UserMainUtils.paddingText(14, stock.getSector());
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

            String nowPriceStr = UserMainUtils.formatRupiah ((int) price);
            String pricePadding = UserMainUtils.paddingText(11, nowPriceStr);
            String priceText = " " + nowPriceStr + pricePadding + "||";

            String fullChangeText = priceChange > 0 ? "+" + (int) priceChange + "(" + pricePercentage + "%)" : (int) priceChange + "(" + pricePercentage + "%)";
            String paddingPercentage = UserMainUtils.paddingText(17, fullChangeText);
            String percentageText = " " + fullChangeText + paddingPercentage + "||";

            String paddingSector = UserMainUtils.paddingText(14, stock.getSector());
            String sectorText = " " + sector + paddingSector + "||";

            String fullLineStock = " " + noStock  + UserMainUtils.paddingText(4, String.valueOf(noStock)) + "|| " + " " + code + "  ||" + priceText + percentageText + sectorText;
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
        List<String> listSbn = UserController.getListSbns();

        return listSbn.size() / 8;
    }

    public static int maxPageListSbnPorto(Users user){
        List<SBNs> listSbn = SecuritiesData.getSbnsList();
        ArrayList<PortfolioItem> sbnPorto = Users.getPortfolio();
        int portoCount = 0;
        for (SBNs sbn : listSbn) {
            for(PortfolioItem porto : sbnPorto){
                if(sbn.getCode().equalsIgnoreCase(porto.getSecurities().getCode())){
                    portoCount++;
                }
            }
        }
        double calculatePage = (double) portoCount / 8;
        int totalpage = 0;
        if(calculatePage > 0.0 && calculatePage < 1.0){
            totalpage = 1;
        }else if(calculatePage > 1.0){
            totalpage = (int) Math.ceil(calculatePage);
        }
        return totalpage;
    }

    public static int maxPageListStockPorto(Users user){
        List<Stocks> listStock = SecuritiesData.getStocksList();
        ArrayList<PortfolioItem> sbnPorto = Users.getPortfolio();
        int portoCount = 0;
        for (Stocks stock : listStock) {
            for(PortfolioItem porto : sbnPorto){
                if(stock.getCode().equalsIgnoreCase(porto.getSecurities().getCode())){
                    portoCount++;
                }
            }
        }
        double calculatePage = (double) portoCount / 8;
        int totalpage = 0;
        if(calculatePage > 0.0 && calculatePage < 1.0){
            totalpage = 1;
        }else if(calculatePage > 1.0){
            totalpage = (int) Math.ceil(calculatePage);
        }
        return totalpage;
    }

    public static List<String> getListSbns(){
        List<String> listSbn = new ArrayList<>();
        int noSbn = 1;
        for(SBNs sbn: SecuritiesData.getSbnsList()){
            double price = sbn.getPrice();
            int quota = sbn.getNationalQuota();
            String interestRate = String.format("%.2f", sbn.getInterestRate());
            LocalDate maturityDate = sbn.getMaturityDate();

            String pricePadding = UserMainUtils.paddingText(11, UserMainUtils.formatRupiah((int) price));
            String quotaPadding = UserMainUtils.paddingText(7, String.valueOf(quota));
            String interestRatePadding = UserMainUtils.paddingText(6, interestRate);
            String maturityDatePadding = UserMainUtils.paddingText(12, maturityDate.toString());

            String sbnText = " " + noSbn + UserMainUtils.paddingText(4, String.valueOf(noSbn)) +"|| " + sbn.getCode() + "   || " + UserMainUtils.formatRupiah ((int) price) + pricePadding + "|| " + quota + quotaPadding + "|| " + interestRate + "%" + interestRatePadding + "|| " + maturityDate + maturityDatePadding + "||";
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
            UserMainUtils.clearScreen();
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
                    double total = stock.getCurrentPrice() * quantity * 100;
                    if (user.getBalance() >= total) {
                        UserMainUtils.clearScreen();
                        user.setBalance(user.getBalance() - total);
                        user.addToPortfolio(stock, quantity, stock.getCurrentPrice());
                        for(int i = 5; i >= 1; i--) {
                            UserMainUtils.clearScreen();
                            System.out.println("||=====================================================================================||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||                               TRANSAKSI BERHASIL                                    ||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||=====================================================================================||");
                            System.out.println("|| Anda Membeli : " + stockCode + UserMainUtils.paddingText(69, stockCode) + "||");
                            System.out.println("|| Jumlah : " + quantity + " LOT" + UserMainUtils.paddingText(71, String.valueOf(quantity)) + "||");
                            System.out.println("|| Harga Per Lembar : Rp. " + UserMainUtils.formatRupiah((long) stock.getCurrentPrice()) + UserMainUtils.paddingText(61, UserMainUtils.formatRupiah((long) stock.getCurrentPrice())) + "||");
                            System.out.println("|| Total Pembayaran : Rp. " + UserMainUtils.formatRupiah((long) total) + UserMainUtils.paddingText(61, UserMainUtils.formatRupiah((long) total)) + "||");
                            System.out.println("||=====================================================================================||");
                            System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
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
                            UserMainUtils.clearScreen();
                            System.out.println("||=====================================================================================||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||                          TRANSAKSI GAGAL, SALDO TIDAK CUKUP                         ||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||=====================================================================================||");
                            System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
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
                                UserMainUtils.clearScreen();
                                System.out.println("||=====================================================================================||");
                                System.out.println("||                                                                                     ||");
                                System.out.println("||                               TRANSAKSI BERHASIL                                    ||");
                                System.out.println("||                                                                                     ||");
                                System.out.println("||=====================================================================================||");
                                System.out.println("|| Anda Membeli : " + stockCode + UserMainUtils.paddingText(69, stockCode) + "||");
                                System.out.println("|| Jumlah : " + quantity + " UNIT" + UserMainUtils.paddingText(70, String.valueOf(quantity)) + "||");
                                System.out.println("|| Harga Per Unit : Rp. " + UserMainUtils.formatRupiah((long) sbn.getPrice()) + UserMainUtils.paddingText(63, UserMainUtils.formatRupiah((long) sbn.getPrice())) + "||");
                                System.out.println("|| Total Pembayaran : Rp. " + UserMainUtils.formatRupiah((long) total) + UserMainUtils.paddingText(61, UserMainUtils.formatRupiah((long) total)) + "||");
                                System.out.println("||=====================================================================================||");
                                System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
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
                                System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM "+ i + UserMainUtils.paddingText(49, "i") +"||");
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
                            UserMainUtils.clearScreen();
                            System.out.println("||=====================================================================================||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||                     TRANSAKSI GAGAL, MELEBIHI KUOTA NASIONAL                        ||");
                            System.out.println("||                                                                                     ||");
                            System.out.println("||=====================================================================================||");
                            System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM "+ i + UserMainUtils.paddingText(49, "i") +"||");
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
        }while (!isStocks && !isSbn);
    }

    public static int getStockBalance(){
        int totalStockBalance = 0;
        for(Stocks stock : SecuritiesData.getStocksList()){
            for(PortfolioItem porto : Users.getPortfolio()){
                if(porto.getSecurities().getCode().equalsIgnoreCase(stock.getCode())){
                    totalStockBalance += (int) (stock.getCurrentPrice() * porto.getQuantity() * 100);
                }
            }
        }
        return totalStockBalance;
    }

    public static int getSbnBalance(Users user){
        int totalSbnBalance = 0;
        for(SBNs sbn : SecuritiesData.getSbnsList()){
            for(PortfolioItem porto : user.getPortfolio()){
                if(porto.getSecurities().getCode().equalsIgnoreCase(sbn.getCode())){
                    Period period = Period.between(LocalDate.now(), sbn.getMaturityDate());
                    int totalMonths = period.getYears() * 12 + period.getMonths();
                    int totalInvest = (int) sbn.simulateProfit(sbn.getInterestRate(), 1, totalMonths);
                    totalSbnBalance += (int) (sbn.getPrice() * porto.getQuantity()) + totalInvest;
                }
            }
        }
        return totalSbnBalance;
    }

    public static void topUpBalance(Users user) {
        System.out.println("||=====================================================================================||");
        System.out.println("|| HALLO" + getCurrentUser().getUsername() + ", AYO TOP UP UNTUK INVESTASI" + UserMainUtils.paddingText(51, getCurrentUser().getUsername()) + "||");
        System.out.println("||=====================================================================================||");
        System.out.println("|| SETIAP TOPUP MAKSIMAL Rp. 10.000.000.000                                            ||");
        System.out.println("||=====================================================================================||");
        System.out.print("|| Masukan Nominal : Rp. ");
        double amount = scanner.nextDouble();
        if (amount > 10000000000.0) {
            for (int i = 5; i >= 1; i--) {
                UserMainUtils.clearScreen();
                System.out.println("||=====================================================================================||");
                System.out.println("||                                                                                     ||");
                System.out.println("||                        TOPUP GAGAL, MELEBIHI BATAS MAKSIMAL                         ||");
                System.out.println("||                                                                                     ||");
                System.out.println("||=====================================================================================||");
                System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
                System.out.println("||=====================================================================================||");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Accounts loggedInAccount = Session.getCurrentUser();
            Routes.userRoutes((Users) loggedInAccount);
        } else {
            if(amount > 0){
                user.addBalance(amount);
                for (int i = 5; i >= 1; i--) {
                    UserMainUtils.clearScreen();
                    System.out.println("||=====================================================================================||");
                    System.out.println("||                                                                                     ||");
                    System.out.println("||                        TOPUP BERHASIL, AYO MULAI INVESTASI                          ||");
                    System.out.println("||                                                                                     ||");
                    System.out.println("||=====================================================================================||");
                    System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
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
                for (int i = 5; i >= 1; i--) {
                    UserMainUtils.clearScreen();
                    System.out.println("||=====================================================================================||");
                    System.out.println("||                                                                                     ||");
                    System.out.println("||                        TOPUP GAGAL NOMINAL TIDAK BOLEH NOL                          ||");
                    System.out.println("||                                                                                     ||");
                    System.out.println("||=====================================================================================||");
                    System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
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

    public static void withdraw(Users user){
        System.out.println("||=====================================================================================||");
        System.out.println("|| HALLO" + getCurrentUser().getUsername() + ", AYO TOP UP UNTUK INVESTASI" + UserMainUtils.paddingText(51, getCurrentUser().getUsername()) + "||");
        System.out.println("||=====================================================================================||");
        System.out.println("|| SETIAP PENARIKAN MAKSIMAL Rp. 10.000.000.000                                        ||");
        System.out.println("||=====================================================================================||");
        System.out.print("|| Masukan Nominal : Rp. ");
        double amount = scanner.nextDouble();
        if (amount > 10000000000.0) {
            for (int i = 5; i >= 1; i--) {
                UserMainUtils.clearScreen();
                System.out.println("||=====================================================================================||");
                System.out.println("||                                                                                     ||");
                System.out.println("||                    PENARIKAN GAGAL, MELEBIHI BATAS MAKSIMAL                         ||");
                System.out.println("||                                                                                     ||");
                System.out.println("||=====================================================================================||");
                System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
                System.out.println("||=====================================================================================||");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Accounts loggedInAccount = Session.getCurrentUser();
            Routes.userRoutes((Users) loggedInAccount);
        } else {
            if(amount > 0){
                user.withdrawBalance(amount);
                for (int i = 5; i >= 1; i--) {
                    UserMainUtils.clearScreen();
                    System.out.println("||=====================================================================================||");
                    System.out.println("||                                                                                     ||");
                    System.out.println("||                    PENARIKAN BERHASIL, AYO MULAI INVESTASI                          ||");
                    System.out.println("||                                                                                     ||");
                    System.out.println("||=====================================================================================||");
                    System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
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
                for (int i = 5; i >= 1; i--) {
                    UserMainUtils.clearScreen();
                    System.out.println("||=====================================================================================||");
                    System.out.println("||                                                                                     ||");
                    System.out.println("||                    PENARIKAN GAGAL NOMINAL TIDAK BOLEH NOL                          ||");
                    System.out.println("||                                                                                     ||");
                    System.out.println("||=====================================================================================||");
                    System.out.println("|| PESAN AKAN TERTUTUP OTOMATIS DALAM " + i + UserMainUtils.paddingText(49, "i") + "||");
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

    public static List<String> listSbnPortofolio(Users user) {
        ArrayList<PortfolioItem> items = Users.getPortfolio();
        List<String> listSbn = new ArrayList<>();
        if (items.isEmpty()) {
            listSbn.add("                       PORTOFOLIO KOSONG                          ||");
            listSbn.add("                         AYO BELI SBN                             ||");
            listSbn.add("                                                                  ||");
            listSbn.add("                                                                  ||");
            listSbn.add("                                                                  ||");
            listSbn.add("                                                                  ||");
            listSbn.add("                                                                  ||");
            listSbn.add("                                                                  ||");
        } else {
            int no = 1;
            for (PortfolioItem item : items) {
                if (item.getSecurities() instanceof SBNs sbn) {
                    String monthInterest = String.valueOf( (int) (((sbn.getInterestRate() / 12) / 100 * (item.getQuantity() * item.getPurchasePrice())) * 0.9));
                    int quantity = item.getQuantity();
                    String stocksText = "  " + no + UserMainUtils.paddingText(3, String.valueOf(no)) +"|| " + item.getSecurities().getCode() + " || " + monthInterest + UserMainUtils.paddingText(12, monthInterest) + "|| " + quantity + UserMainUtils.paddingText(8, String.valueOf(quantity)) + "|| " + sbn.getInterestRate() + "%" + UserMainUtils.paddingText(6, String.valueOf(sbn.getInterestRate())) + "|| " + sbn.getMaturityDate() + "  ||";
                    listSbn.add(stocksText);
                }
                no++;
            }
            int blankSpace = 8 - (listSbn.size() % 8);
            for (int i = 0; i <= blankSpace; i++) {
                listSbn.add("                                                                  ||");
            }
        }
        return (listSbn);
    }

    public static List<String> listStockPortofolio(Users user){
        ArrayList<PortfolioItem> items = Users.getPortfolio();
        List<String> listStock = new ArrayList<>();
        if (items.isEmpty()) {
            listStock.add("                       PORTOFOLIO KOSONG                          ||");
            listStock.add("                        AYO BELI SAHAM                            ||");
            listStock.add("                                                                  ||");
            listStock.add("                                                                  ||");
            listStock.add("                                                                  ||");
            listStock.add("                                                                  ||");
            listStock.add("                                                                  ||");
            listStock.add("                                                                  ||");
        } else {
            int no = 1;
            for (PortfolioItem item : items) {
                if (item.getSecurities() instanceof Stocks stock) {
                    ArrayList<Double> history = stock.getPriceHistory();
                    double latestPrice = history.isEmpty() ? stock.getPrice() : history.getLast();
                    String stockCapital = UserMainUtils.formatRupiah((long) item.getPurchasePrice() * 100 * item.getQuantity());
                    String paddingStockCapital = UserMainUtils.paddingText(14, stockCapital);
                    String currentStockValue = UserMainUtils.formatRupiah((long) (item.getQuantity() * 100 * history.getLast()));
                    String paddingCurrentStockValue = UserMainUtils.paddingText(16, currentStockValue);
                    int quatity = item.getQuantity() * 100;
                    String paddingQuantity = UserMainUtils.paddingText(13, String.valueOf(quatity));
                    String stocksText = " " + no + UserMainUtils.paddingText(3, String.valueOf(no)) + "|| " + item.getSecurities().getCode() + "   || " + stockCapital + paddingStockCapital + "|| " + currentStockValue + paddingCurrentStockValue + "|| " + quatity + paddingQuantity + "||";
                    listStock.add(stocksText);
                    no++;
                }
            }
            int blankSpace = 8 - (listStock.size() % 8);
            for (int i = 0; i <= blankSpace; i++) {
                listStock.add("                                                                  ||");
            }
        }
        return(listStock);
    }

    public static List<String> SimulationSbn(String code){
        List<String> contentSimulationSbn = new ArrayList<>();
        contentSimulationSbn.add("==================================================================||");
        contentSimulationSbn.add(" HALLO, " + getCurrentUser().getUsername() + UserMainUtils.paddingText(58, getCurrentUser().getUsername()) + "||");
        for(SBNs sbn: SecuritiesData.getSbnsList()){
            if(sbn.getCode().equalsIgnoreCase(code)){
                int sbnrate = (int) (((sbn.getInterestRate() / 12) / 100 * sbn.getPrice()) * 0.9);
                Period period = Period.between(LocalDate.now(), sbn.getMaturityDate());
                int totalMonths = period.getYears() * 12 + period.getMonths();
                int totalInvest = (int) sbn.simulateProfit(sbn.getInterestRate(), 1, totalMonths);
                contentSimulationSbn.add("                                                                  ||");
                contentSimulationSbn.add("==================================================================||");
                contentSimulationSbn.add(" HASIL SIMULASI SBN : " + code + UserMainUtils.paddingText(44, code) + "||");
                contentSimulationSbn.add("==================================================================||");
                contentSimulationSbn.add(" BUNGA/TAHUN : " + sbn.getInterestRate() + "%" + UserMainUtils.paddingText(50, String.valueOf(sbn.getInterestRate())) + "||");
                contentSimulationSbn.add(" BUNGA/PERBULAN : " + String.format("%.2f", sbn.getInterestRate() / 12) + "%" + UserMainUtils.paddingText(47, String.format("%.2f", sbn.getInterestRate() / 12)) + "||");
                contentSimulationSbn.add("------------------------------------------------------------------||");
                contentSimulationSbn.add(" HARGA : Rp. " + UserMainUtils.formatRupiah( (int) sbn.getPrice()) + UserMainUtils.paddingText(53, String.valueOf(sbn.getPrice())) + "||");
                contentSimulationSbn.add("------------------------------------------------------------------||");
                contentSimulationSbn.add(" JATUH TEMPO : " + sbn.getMaturityDate() + UserMainUtils.paddingText(51, String.valueOf(sbn.getMaturityDate())) + "||");
                contentSimulationSbn.add("------------------------------------------------------------------||");
                contentSimulationSbn.add(" KUPON PER-BULAN (1 UNIT) : Rp. " + UserMainUtils.formatRupiah(sbnrate) + UserMainUtils.paddingText(33, String.valueOf(sbnrate)) + "||");
                contentSimulationSbn.add("------------------------------------------------------------------||");
                contentSimulationSbn.add(" HASIL INVESTASI HINGGA JATUH TEMPO : Rp. " +  UserMainUtils.formatRupiah(totalInvest) + UserMainUtils.paddingText(24, UserMainUtils.formatRupiah(totalInvest)) + "||");
                contentSimulationSbn.add("==================================================================||");
                contentSimulationSbn.add("                  INPUT KODE SBN UNTUK SIMULASI                   ||");
                contentSimulationSbn.add("==================================================================||");
                return contentSimulationSbn;
            }
        }

        contentSimulationSbn.add("                                                                  ||");
        contentSimulationSbn.add("==================================================================||");
        contentSimulationSbn.add("                                                                  ||");
        contentSimulationSbn.add("                KODE SEBELUMNYA BUKANLAH KODE SBN                 ||");
        for(int i = 0; i < 10; i++){
            contentSimulationSbn.add("                                                                  ||");
        }
        contentSimulationSbn.add("==================================================================||");
        contentSimulationSbn.add("             MASUKAN KODE SESUAI DENGAN SBN YANG ADA              ||");
        contentSimulationSbn.add("==================================================================||");
        return contentSimulationSbn;
    }

    public static void sellStock(String code, Users user){
        ArrayList<PortfolioItem> items = Users.getPortfolio();
        boolean found = false;
        for(PortfolioItem item : new ArrayList<>(items)){
            if(item.getSecurities().getCode().equalsIgnoreCase(code)){
                found = true;
                System.out.println("||=====================================================================================||");
                System.out.println("||                                                                                     ||");
                System.out.println("|| ANDA AKAN MENJUAL SAHAM : " + code + UserMainUtils.paddingText(58, code) + "||");
                System.out.println("|| TOTAL SAHAM YANG DIMILIKI : " + code + UserMainUtils.paddingText(55, String.valueOf(item.getQuantity())) + "||");
                System.out.println("||                                                                                     ||");
                System.out.println("||=====================================================================================||");
                System.out.print("|| Masukan Jumlah LOT : ");
                int lotQuantity = scanner.nextInt();
                if(lotQuantity > item.getQuantity() || lotQuantity < 0){
                    UserMainUtils.clearScreen();
                    System.out.println("||=====================================================================================||");
                    System.out.println("||              TRANSAKSI PENJUALAN GAGAL, SAHAM YANG DIMILIKI KURANG                  ||");
                    System.out.println("||=====================================================================================||");
                    UserMainUtils.threeSecondClodeMessage();
                }else{
                    if (item.getSecurities() instanceof Stocks stock) {
                        ArrayList<Double> history = stock.getPriceHistory();
                        double sellPrice = history.isEmpty() ? stock.getPrice() : history.getLast();
                        double buyPrice = item.getPurchasePrice();
                        double total = lotQuantity * 100 * sellPrice;
                        int remainingStock = item.getQuantity() - lotQuantity;
                        item.decreaseQuantity(lotQuantity);
                        user.setBalance(user.getBalance() + total);
                        if (item.getQuantity() == 0) {
                            items.remove(item);
                        }
                        UserView.successSellStock(remainingStock, (int) total, sellPrice, buyPrice, lotQuantity);
                    }
                }
                break;
            }
        }
        if (!found) {
            System.out.println("||=====================================================================================||");
            System.out.println("||                           SAHAM TIDAK DAPAT DITEMUKAN                               ||");
            System.out.println("||=====================================================================================||");
            UserMainUtils.threeSecondClodeMessage();
        }
    }

    public static void manageWatchlist(Users user, String stockCode) {
        List<String> watchlist = user.getWatchlist();

        boolean isValidStock = false;
        for (Stocks stock : SecuritiesData.getStocksList()) {
            if (stock.getCode().equalsIgnoreCase(stockCode)) {
                isValidStock = true;
                break;
            }
        }

        if (!isValidStock) {
            System.out.println("||=====================================================================================||");
            System.out.println("||        KODE SAHAM TIDAK VALID ATAU BUKAN MERUPAKAN SAHAM YANG TERDAFTAR             ||");
            System.out.println("||=====================================================================================||");
            UserMainUtils.threeSecondClodeMessage();
        }

        if (watchlist.contains(stockCode.toUpperCase())) {
            watchlist.remove(stockCode.toUpperCase());
            System.out.println("||=====================================================================================||");
            System.out.println("||                  SAHAM " + stockCode + " BERHASIL DIHAPUS DARI WATCHLIST                         ||");
            System.out.println("||=====================================================================================||");
            UserMainUtils.threeSecondClodeMessage();
        } else {
            if (watchlist.size() >= 8) {
                System.out.println("||=====================================================================================||");
                System.out.println("||         WATCHLIST PENUH! MAKSIMAL HANYA 8 SAHAM DI WATCHLIST                        ||");
                System.out.println("||=====================================================================================||");
                UserMainUtils.threeSecondClodeMessage();
            } else {
                watchlist.add(stockCode.toUpperCase());
                System.out.println("||=====================================================================================||");
                System.out.println("||                  SAHAM " + stockCode + " BERHASIL DITAMBAHKAN KE WATCHLIST                       ||");
                System.out.println("||=====================================================================================||");
                UserMainUtils.threeSecondClodeMessage();
            }
        }
    }

}
