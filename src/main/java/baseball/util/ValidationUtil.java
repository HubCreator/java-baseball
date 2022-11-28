package baseball.util;

import baseball.enums.ConstVariable;
import baseball.enums.RetryOrQuit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static void isValid(String input) {
        isValidSize(input);
        isDistinct(input);
        isValidRange(input);
    }

    public static void isValidRange(String input) {
        List<Integer> list = mapNumber(input);
        for (Integer digit : list) {
            if (digit < ConstVariable.MIN.getValue() || digit > ConstVariable.MAX.getValue()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static List<Integer> mapNumber(String input) {
        List<Integer> result = new ArrayList<>();
        IntStream
                .range(0, input.length())
                .forEach(index -> result.add(input.charAt(index) - '0'));
        return result;
    }

    public static void isValidSize(String input) {
        if (input.length() != ConstVariable.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDistinct(String input) {
        long count = input.chars()
                .distinct()
                .count();
        if (count != ConstVariable.SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isRetryOrQuit(String input) {
        if (!RetryOrQuit.QUIT.isMatch(input) && !RetryOrQuit.RETRY.isMatch(input)) {
            throw new IllegalArgumentException();
        }
    }
}
