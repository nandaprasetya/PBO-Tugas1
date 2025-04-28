package Routes;

import Account.Users;
import Controllers.UserController;
import Data.SecuritiesData;
import Securities.Securities;
import Securities.Stocks;
import Utils.MainUtils;
import View.UserView;

import java.util.Scanner;

public class Routes {
    public static void userRoutes(Users user){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        UserView.userMainMenu();
        UserView.lineInput();
        String choice = scanner.nextLine();
        do {
            MainUtils.clearScreen();
            switch (choice){
                case "1" -> {
                    int page = 1;
                    UserView.viewListStock(page);
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        do {
                            MainUtils.clearScreen();
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
                            MainUtils.clearScreen();
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
//                    running = false;
                }
                case "5" -> {
                    int page = 1;
                    UserView.viewSbnPortofolio(user, page);
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        do {
                            MainUtils.clearScreen();
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
                            MainUtils.clearScreen();
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
                    MainUtils.clearScreen();
                    UserView.landingSimulationSbn();
                    UserView.lineInput();
                    choice = scanner.nextLine();
                    if(!choice.matches("[0-9]")){
                        do{
                            MainUtils.clearScreen();
                            UserView.viewSimulationSbn(choice);
                            UserView.lineInput();
                            choice = scanner.nextLine();
                        } while(!choice.matches("[0-9]"));
                    }
                }
                case "0" -> {
                    running = false;
                }
                default -> {
                    UserView.userMainMenu();
                    UserView.lineInput();
                    choice = scanner.nextLine();
                }
            }
        }while(!choice.equals("0"));
    }
}
