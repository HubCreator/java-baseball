package baseball.util;

import baseball.enums.Const;
import baseball.enums.RetryOrQuit;

public class ValidationUtil {



    private ValidationUtil() {
    }

    public static void isValidRange(String input) {
        int digit = isDigit(input);
        if (digit < Const.MIN.getValue() || digit > Const.MAX.getValue()) {
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
        if (input.length() != Const.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDistinct(String input) {
        long count = input.chars()
                .distinct()
                .count();
        if (count != Const.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isRetryOrQuit(String input) {
        if (!RetryOrQuit.QUIT.isQuit(input) && !RetryOrQuit.RETRY.isRetry(input)) {
            throw new IllegalArgumentException();
        }
    }
}
