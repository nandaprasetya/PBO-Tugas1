package View;

import Data.SecuritiesData;
import Securities.Stocks;
import account.Users;

import java.util.ArrayList;
import java.util.List;

import static account.Session.getCurrentUser;

public class UserView {
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
                "|| [8] TAMBAH/HAPUS||",
                "||     WATCHLIST   ||",
                "|| [0] LOGOUT      ||",
                "||                 ||",
                "||=================||"
        };
    }

    public static List<String> getLimitedWatchlist(List<String> watchlist, int maxItems) {
        if (watchlist.size() > maxItems) {
            return new ArrayList<>(watchlist.subList(0, maxItems));
        }
        return new ArrayList<>(watchlist);
    }

    public static void userMainMenu(){
        String[] mainMenu = listMainMenu();
        List<String> contentLandingPage = new ArrayList<>();
        contentLandingPage.add("==================================================================||");

        String username = getCurrentUser().getUsername();
        String baseText = " SELAMAT DATANG, " + username;
        int spacesNeeded = 66 - baseText.length();
        String padding = "";
        for (int i = 0; i < spacesNeeded; i++){
            padding += " ";
        }

        String fullLine = baseText + padding + "||";
        contentLandingPage.add(fullLine);
        contentLandingPage.add("                                                                  ||");
        contentLandingPage.add("==================================================================||");
        contentLandingPage.add(" WATCHLIST ANDA                                                   ||");
        contentLandingPage.add("==================================================================||");
        contentLandingPage.add(" NO. || KODE   || HARGA    || PERSENTASE         || SEKTOR        ||");
        contentLandingPage.add("=====||========||==========||====================||===============||");
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
                    } else if (stock.getPriceHistory().size() == 1) {
                        lastPrice = stock.getPreviousPrice();
                        nowPrice = stock.getCurrentPrice();
                    } else {
                        lastPrice = stock.getPrice();
                        nowPrice = stock.getPrice();
                    }

                    String codeText = watchlist.get(watchlistNumber - 1) + "   ||";
                    String pricePadding = "";
                    String nowPriceStr = String.valueOf((int) nowPrice);
                    for(int i = 0; i < 7 - nowPriceStr.length(); i++){
                        pricePadding += " ";
                    }
                    String priceText = " " + nowPrice + pricePadding + "||";

                    String fullChangeText = (nowPrice - lastPrice) > 0 ? "+" + (int) (nowPrice - lastPrice) + "(" + stock.getPriceChangePercentage() + "%)" : (int) (nowPrice - lastPrice) + "(" + stock.getPriceChangePercentage() + "%)";
                    String paddingPercentage = " ".repeat(Math.max(0, 19 - fullChangeText.length()));
                    String percentageText = " " + fullChangeText + paddingPercentage + "||";
                    String paddingSector = "";
                    for(int i = 0; i < 14 - stock.getSector().length(); i++){
                        paddingSector += " ";
                    }
                    String sectorText = " " + stock.getSector() + paddingSector + "||";
                    String fullLineStock = " " + watchlistNumber + "   || " + codeText + priceText + percentageText + sectorText;
                    watchlistNumber += 1;
                    contentLandingPage.add(fullLineStock);
                }
            }
        }
        if(watchlist.size() < 8){
            for(int i = 0; i < 8 - watchlist.size(); i++){
                contentLandingPage.add("                                                                  ||");
            }
        }
        contentLandingPage.add("==================================================================||");
        contentLandingPage.add("     INPUT NO UNTUK MELIHAT MAIN MENU & KODE SAHAM UNTUK DETAIL   ||");
        contentLandingPage.add("==================================================================||");
        for (int i = 0; i < mainMenu.length; i++){
            System.out.println(mainMenu[i] + contentLandingPage.get(i));
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
        System.out.println("|| [0] LOGOUT      || 7   || ASII   || 4920     || +120(+2.50%)       || INDUSTRIAL    ||");
        System.out.println("||                 || 8   || BBNI   || 4240     || -10(-0.24%)        || FINANCE       ||");
        System.out.println("||                 ||==================================================================||");
        System.out.println("||                 ||     INPUT NO UNTUK MELIHAT MAIN MENU & KODE SAHAM UNTUK DETAIL   ||");
        System.out.println("||=================||==================================================================||");
    }
}
