package baseball;

public class ValidationUtil {

    public static final int MIN = 1;
    public static final int MAX = 9;
    public static final int SIZE = 3;

    private ValidationUtil() {
    }

    public static void isValidRange(String input) {
        int digit = isDigit(input);
        if (digit < MIN || digit > MAX) {
            throw new IllegalArgumentException();
        }
    }

    private static int isDigit(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void isValidSize(String input) {
        if (input.length() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDistinct(String input) {
        long count = input.chars()
                .distinct()
                .count();
        if (count != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static void isRetryOrQuit(String input) {
        if (!RetryOrQuit.QUIT.isQuit(input) && !RetryOrQuit.RETRY.isRetry(input)) {
            throw new IllegalArgumentException();
        }
    }
}
