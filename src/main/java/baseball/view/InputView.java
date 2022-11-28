package baseball.view;

import baseball.enums.ViewMessage;
import baseball.util.ValidationUtil;

public class InputView {

    public static String readNumbers(String input) {
        printMessage(ViewMessage.INPUT_MESSAGE);
        ValidationUtil.isValid(input);
        return input;
    }

    public static void printStartMessage() {
        printMessage(ViewMessage.START_MESSAGE);
    }

    private static void printMessage(ViewMessage message) {
        System.out.println(message.getValue());
    }
}
