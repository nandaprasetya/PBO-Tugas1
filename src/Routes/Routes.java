package Routes;

import View.UserView;

import java.util.Scanner;

public class Routes {
    public static void userRoutes(){
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            UserView.userMainMenu();
            running = false;
        }
    }
}
