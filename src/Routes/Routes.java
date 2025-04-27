package Routes;

import Account.Users;
import Controllers.UserController;
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
        while (running) {
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
                    running = false;
                }
                case "0" -> {
                    running = false;
                }
            }
        }
    }
}
