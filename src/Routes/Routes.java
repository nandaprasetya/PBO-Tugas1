package Routes;

import Account.Login;
import Account.Session;
import Account.Users;
import Controllers.UserController;
import Controllers.AdminController;
import Utils.UserMainUtils;
import View.UserView;

import java.util.Scanner;

public class Routes {
    public static void userRoutes(Users user) {
        Scanner scanner = new Scanner(System.in);
        boolean continueSession = true;
        String choice="";
        if (Session.getCurrentUser() == null) {
            Session.setCurrentUser(user);
        }

        if (Session.getCurrentUser() != null) {
            UserMainUtils.clearScreen();
            UserView.userMainMenu();
            UserView.lineInput();
            choice = scanner.nextLine();
        }

        while(continueSession) {
            if (Session.getCurrentUser() != null) {
                switch (choice) {
                    case "1" -> choice = handleStockListView(scanner);
                    case "2" -> choice = handleSbnListView(scanner);
                    case "3" -> handleBuySecurities(user, scanner);
                    case "4" -> choice = handleBalanceOperations(user, scanner);
                    case "5" -> choice = handleSbnPortfolioView(user, scanner);
                    case "6" -> choice = handleStockPortfolioView(user, scanner);
                    case "7" -> choice = handleSbnSimulation(scanner);
                    case "8" -> handleSellStock(user, scanner);
                    case "9" -> handleWatchlistManagement(user, scanner);
                    case "0" -> {
                        Session.logout();
                        UserView.logout();
                        continueSession = false;
                    }
                    default -> {
                    }
                }
            } else {
                continueSession = false;
            }
        }
    }

    private static String handleStockListView(Scanner scanner) {
        int page = 1;
        UserView.viewListStock(page);
        UserView.lineInput();
        String choice = scanner.nextLine();
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
        return choice;
    }

    private static String handleSbnListView(Scanner scanner) {
        int page = 1;
        UserView.viewListSbn(page);
        UserView.lineInput();
        String choice = scanner.nextLine();
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
        return choice;
    }

    private static void handleBuySecurities(Users user, Scanner scanner) {
        UserMainUtils.clearScreen();
        UserView.viewBuy(user);
        System.out.print("|| Kode Saham / Sbn : ");
        String code = scanner.next();
        scanner.nextLine();

        if(!code.matches("[0-9]")) {
            UserController.buyStockSbn(user, code);
        }
    }

    private static String handleBalanceOperations(Users user, Scanner scanner) {
        UserView.viewBalance(user);
        UserView.lineInput();
        String choice = scanner.nextLine();

        if(choice.equals("11")) {
            UserController.topUpBalance(user);
        } else if(choice.equals("12")) {
            UserController.withdraw(user);
        }

        return choice;
    }

    private static String handleSbnPortfolioView(Users user, Scanner scanner) {
        int page = 1;
        UserView.viewSbnPortofolio(user, page);
        UserView.lineInput();
        String choice = scanner.nextLine();
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
        return choice;
    }

    private static String handleStockPortfolioView(Users user, Scanner scanner) {
        int page = 1;
        UserView.viewStockPortofolio(user, page);
        UserView.lineInput();
        String choice = scanner.nextLine();
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
        return choice;
    }

    private static String handleSbnSimulation(Scanner scanner) {
        UserMainUtils.clearScreen();
        UserView.landingSimulationSbn();
        UserView.lineInput();
        String choice = scanner.nextLine();
        if(!choice.matches("[0-9]")){
            do{
                UserMainUtils.clearScreen();
                UserView.viewSimulationSbn(choice);
                UserView.lineInput();
                choice = scanner.nextLine();
            } while(!choice.matches("[0-9]"));
        }
        return choice;
    }

    private static void handleSellStock(Users user, Scanner scanner) {
        boolean sellingStock = true;

        while(sellingStock && Session.getCurrentUser() != null) {
            UserView.viewSellStock(user);
            String input = scanner.nextLine();

            if(input.matches("[0-9]")) {
                sellingStock = false;
            } else {
                UserController.sellStock(input, user);
            }
        }
    }

    private static void handleWatchlistManagement(Users user, Scanner scanner) {
        UserView.viewLandingManageWatchlist();
        UserView.lineInput();
        String choice = scanner.nextLine();

        if(!choice.matches("[0-9]")) {
            UserController.manageWatchlist(user, choice);
        }
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