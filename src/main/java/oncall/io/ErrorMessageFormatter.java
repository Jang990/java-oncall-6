package oncall.io;

public class ErrorMessageFormatter {
    private static final String format = "[ERROR] %s";

    public static String formatted(String message) {
        return format.formatted(message);
    }
}
