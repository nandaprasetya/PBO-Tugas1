package Routes;

import Account.Login;
import Account.Session;
import Account.Users;
import Controllers.UserController;
import Controllers.AdminController;
import Data.SecuritiesData;
import Securities.Securities;
import Securities.Stocks;
import Utils.UserMainUtils;
import View.AdminView;
import View.UserView;
import com.sun.tools.javac.Main;

import java.util.Locale;
import java.util.Scanner;

public class Routes {
    public static void userRoutes(Users user){
        Scanner scanner = new Scanner(System.in);
        UserMainUtils.clearScreen();
        UserView.userMainMenu();
        UserView.lineInput();
        String choice = scanner.nextLine();
        do {
            UserMainUtils.clearScreen();
            switch (choice){
                case "1" -> {
                    int page = 1;
                    UserView.viewListStock(page);
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        do {
                            UserMainUtils.clearScreen();
                            if(choice.equals("NEXT")){
                                if(page < UserController.maxPageListStock()){
                                    page += 1;
                                }
                                UserView.viewListStock(page);
                                UserView.lineInput();
                                choice = scanner.nextLine();
                            }else if(choice.equals("PREV")){
                                if(page > 1){
                                    page -= 1;
                                }
                                UserView.viewListStock(page);
                                UserView.lineInput();
                                choice = scanner.nextLine();
                            }
                        }while(choice.equals("NEXT") || choice.equals("PREV"));
                    }
                }
                case "2" -> {
                    int page = 1;
                    UserView.viewListSbn(page);
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        do {
                            UserMainUtils.clearScreen();
                            if(choice.equals("NEXT")){
                                if(page < UserController.maxPageListSbn()){
                                    page += 1;
                                }
                                UserView.viewListSbn(page);
                                UserView.lineInput();
                                choice = scanner.nextLine();
                            }else if(choice.equals("PREV")){
                                if(page > 1){
                                    page -= 1;
                                }
                                UserView.viewListSbn(page);
                                UserView.lineInput();
                                choice = scanner.nextLine();
                            }
                        }while(choice.equals("NEXT") || choice.equals("PREV"));
                    }
                }
                case "3" -> {
                    UserController.buyStockSbn(user);
                }
                case "4" -> {
                    UserView.viewBalance(user);
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(choice.equals("11")){
                        UserController.topUpBalance(user);
                    }else if(choice.equals("12")){
                        UserController.withdraw(user);
                    }
                }
                case "5" -> {
                    int page = 1;
                    UserView.viewSbnPortofolio(user, page);
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        do {
                            UserMainUtils.clearScreen();
                            if(choice.equals("NEXT")){
                                if(page < UserController.maxPageListSbnPorto(user)){
                                    page += 1;
                                }
                                UserView.viewSbnPortofolio(user, page);
                                UserView.lineInput();
                                choice = scanner.nextLine();
                            }else if(choice.equals("PREV")){
                                if(page > 1){
                                    page -= 1;
                                }
                                UserView.viewSbnPortofolio(user, page);
                                UserView.lineInput();
                                choice = scanner.nextLine();
                            }
                        }while(choice.equals("NEXT") || choice.equals("PREV"));
                    }
                }
                case "6" -> {
                    int page = 1;
                    UserView.viewStockPortofolio(user, page);
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        do {
                            UserMainUtils.clearScreen();
                            if(choice.equals("NEXT")){
                                if(page < UserController.maxPageListStockPorto(user)){
                                    page += 1;
                                }
                                UserView.viewStockPortofolio(user, page);
                                UserView.lineInput();
                                choice = scanner.nextLine();
                            }else if(choice.equals("PREV")){
                                if(page > 1){
                                    page -= 1;
                                }
                                UserView.viewStockPortofolio(user, page);
                                UserView.lineInput();
                                choice = scanner.nextLine();
                            }
                        }while(choice.equals("NEXT") || choice.equals("PREV"));
                    }
                }
                case "7" -> {
                    UserMainUtils.clearScreen();
                    UserView.landingSimulationSbn();
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        do{
                            UserMainUtils.clearScreen();
                            UserView.viewSimulationSbn(choice);
                            UserView.lineInput();
                            choice = scanner.nextLine();
                        } while(!choice.matches("[0-9]"));
                    }
                }
                case "8" -> {
                    do{
                        UserView.viewSellStock(user);
                        choice = scanner.nextLine();
                        if(!choice.matches("[0-9]")){
                            UserController.sellStock(choice, user);
                        }
                    }while(!choice.matches("[0-9]"));
                }
                case "9" -> {
                    UserView.viewLandingManageWatchlist();
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        UserController.manageWatchlist(user, choice);
                    }
                }
                case "0" -> {
                    Session.logout();
                    UserView.logout();
                }
                default -> {
                    UserView.userMainMenu();
                    UserView.lineInput();
                    choice = scanner.nextLine();
                }
            }
        }while(!choice.equals("0"));
    }

    public static void startAdmin(Scanner scanner) {
        AdminController.start(scanner);
    }

    public static void loginFailedView() {
        System.out.println();
        System.out.println("||==================================================================||");
        System.out.println("||                          LOGIN GAGAL                             ||");
        System.out.println("||      Username atau password Anda salah. Silakan coba lagi!       ||");
        System.out.println("||==================================================================||");
    }
}
