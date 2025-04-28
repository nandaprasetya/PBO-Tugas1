package Utils;

public class MainUtils {
    public static String paddingText(int length, String text){
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
}
