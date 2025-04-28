package Controllers;

import Account.Users;
import Data.SecuritiesData;
import Securities.Stocks;
import Utils.MainUtils;

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
                    String pricePadding = MainUtils.paddingText(7, nowPriceStr);
                    String priceText = " " + nowPrice + pricePadding + "||";

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

}
