package baseball.view;

import baseball.enums.RetryOrQuit;
import baseball.enums.ViewMessage;
import baseball.util.ValidationUtil;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readNumbers() {
        printMessage(ViewMessage.INPUT_MESSAGE);
        ValidationUtil.isValid(Console.readLine());

        return Console.readLine();
    }

    public static void printStartMessage() {
        printMessageNewLine(ViewMessage.START_MESSAGE);
    }

    public static boolean retryOrNot() {
        printMessageNewLine(ViewMessage.RETRY_OR_QUIT_MESSAGE);
        ValidationUtil.isRetryOrQuit(Console.readLine());

        return RetryOrQuit.RETRY.isMatch(Console.readLine());
    }

    private static void printMessage(ViewMessage message) {
        System.out.print(message.getValue());
    }

    private static void printMessageNewLine(ViewMessage message) {
        System.out.println(message.getValue());
    }
}
