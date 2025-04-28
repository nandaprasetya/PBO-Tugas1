package Utils;

import java.util.List;

public class AdminMainUtils {

    public static String paddingText(int length, String text) {
        if (text.length() >= length) {
            return text.substring(0, length);
        } else {
            StringBuilder sb = new StringBuilder(text);
            while (sb.length() < length) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }

    public static String formatRow(List<String> columns, List<Integer> widths) {
        StringBuilder sb = new StringBuilder();
        sb.append("||");
        for (int i = 0; i < columns.size(); i++) {
            String cell = columns.get(i);
            int width = widths.get(i);
            sb.append(' ').append(paddingText(width, cell)).append(" ||");
        }
        return sb.toString();
    }
}
