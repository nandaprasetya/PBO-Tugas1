package View;

import Controllers.UserController;
import Data.SecuritiesData;
import Securities.Stocks;
import Account.Users;
import Utils.MainUtils;

import java.util.ArrayList;
import java.util.List;

import static Account.Session.getCurrentUser;

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

    public static void userMainMenu(){
        String[] mainMenu = listMainMenu();
        List<String> contentLandingPage = UserController.listWatchlist();
        contentLandingPage.add("==================================================================||");

        String username = getCurrentUser().getUsername();
        String baseText = " SELAMAT DATANG, " + username;
        String fullLine = baseText + MainUtils.paddingText(66, baseText) + "||";

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
                    System.out.print("     INPUT NO UNTUK MELIHAT MAIN MENU & KODE SAHAM UNTUK DETAIL   ||");
                } else if (i == 18) {
                    System.out.print("==================================================================||");
                }
                j += 1;
            }
            System.out.println();
        }
//
//        contentLandingPage.add("==================================================================||");
//        contentLandingPage.add("     INPUT NO UNTUK MELIHAT MAIN MENU & KODE SAHAM UNTUK DETAIL   ||");
//        contentLandingPage.add("==================================================================||");
//        for (int i = 0; i < mainMenu.length; i++){
//            System.out.println(mainMenu[i] + contentLandingPage.get(i));
//        }
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
