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
        if (Session.getCurrentUser() == null) {
            Session.setCurrentUser(user);
        }

        while(continueSession) {
            UserMainUtils.clearScreen();

            if (Session.getCurrentUser() != null) {
                UserView.userMainMenu();
                UserView.lineInput();

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1" -> handleStockListView(scanner);
                    case "2" -> handleSbnListView(scanner);
                    case "3" -> handleBuySecurities(user, scanner);
                    case "4" -> handleBalanceOperations(user, scanner);
                    case "5" -> handleSbnPortfolioView(user, scanner);
                    case "6" -> handleStockPortfolioView(user, scanner);
                    case "7" -> handleSbnSimulation(scanner);
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

    private static void handleStockListView(Scanner scanner) {
        int page = 1;
        boolean viewingList = true;

        while(viewingList) {
            UserMainUtils.clearScreen();
            UserView.viewListStock(page);
            UserView.lineInput();
            String input = scanner.nextLine();

            if(input.matches("[0-9]")) {
                viewingList = false;
            } else if(input.equals("NEXT")) {
                if(page < UserController.maxPageListStock()) {
                    page += 1;
                }
            } else if(input.equals("PREV")) {
                if(page > 1) {
                    page -= 1;
                }
            } else {
                viewingList = false;
            }
        }
    }

    private static void handleSbnListView(Scanner scanner) {
        int page = 1;
        boolean viewingList = true;

        while(viewingList) {
            UserMainUtils.clearScreen();
            UserView.viewListSbn(page);
            UserView.lineInput();
            String input = scanner.nextLine();

            if(input.matches("[0-9]")) {
                viewingList = false;
            } else if(input.equals("NEXT")) {
                if(page < UserController.maxPageListSbn()) {
                    page += 1;
                }
            } else if(input.equals("PREV")) {
                if(page > 1) {
                    page -= 1;
                }
            } else {
                viewingList = false;
            }
        }
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

    private static void handleBalanceOperations(Users user, Scanner scanner) {
        UserView.viewBalance(user);
        UserView.lineInput();
        String choice = scanner.nextLine();

        if(choice.equals("11")) {
            UserController.topUpBalance(user);
        } else if(choice.equals("12")) {
            UserController.withdraw(user);
        }
    }

    private static void handleSbnPortfolioView(Users user, Scanner scanner) {
        int page = 1;
        boolean viewingPortfolio = true;

        while(viewingPortfolio) {
            UserMainUtils.clearScreen();
            UserView.viewSbnPortofolio(user, page);
            UserView.lineInput();
            String input = scanner.nextLine();

            if(input.matches("[0-9]")) {
                viewingPortfolio = false;
            } else if(input.equals("NEXT")) {
                if(page < UserController.maxPageListSbnPorto(user)) {
                    page += 1;
                }
            } else if(input.equals("PREV")) {
                if(page > 1) {
                    page -= 1;
                }
            } else {
                viewingPortfolio = false;
            }
        }
    }

    private static void handleStockPortfolioView(Users user, Scanner scanner) {
        int page = 1;
        boolean viewingPortfolio = true;

        while(viewingPortfolio) {
            UserMainUtils.clearScreen();
            UserView.viewStockPortofolio(user, page);
            UserView.lineInput();
            String input = scanner.nextLine();

            if(input.matches("[0-9]")) {
                viewingPortfolio = false;
            } else if(input.equals("NEXT")) {
                if(page < UserController.maxPageListStockPorto(user)) {
                    page += 1;
                }
            } else if(input.equals("PREV")) {
                if(page > 1) {
                    page -= 1;
                }
            } else {
                viewingPortfolio = false;
            }
        }
    }

    private static void handleSbnSimulation(Scanner scanner) {
        UserMainUtils.clearScreen();
        UserView.landingSimulationSbn();
        UserView.lineInput();
        String input = scanner.nextLine();

        if(!input.matches("[0-9]")) {
            boolean simulationRunning = true;
            while(simulationRunning) {
                UserMainUtils.clearScreen();
                UserView.viewSimulationSbn(input);
                UserView.lineInput();
                input = scanner.nextLine();

                if(input.matches("[0-9]")) {
                    simulationRunning = false;
                }
            }
        }
    }

    private static void handleSellStock(Users user, Scanner scanner) {
        boolean sellingStock = true;

        while(sellingStock) {
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