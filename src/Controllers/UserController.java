package Controllers;

import Account.Users;
import Data.SecuritiesData;
import Securities.SBNs;
import Securities.Stocks;
import Utils.MainUtils;
import com.sun.tools.javac.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserController {
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
}
