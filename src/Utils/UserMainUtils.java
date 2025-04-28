package Utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class UserMainUtils {
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

    public static String formatRupiah(long number) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.'); //

        DecimalFormat formatter = new DecimalFormat("#,###", symbols);

        return formatter.format(number);
    }
}
