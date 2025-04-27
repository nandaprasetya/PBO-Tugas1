package Utils;

public class MainUtils {
    public static String paddingText(int length, String text){
        String padding = "";
        for (int i = 0; i < length - text.length(); i++) {
            padding += " ";
        }
        return padding;
    }

    public static void clearScreen() {
        System.out.println("\033c");
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

}
