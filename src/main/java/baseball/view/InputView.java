package baseball.view;

import baseball.util.ValidationUtil;

public class InputView {

    public static String readNumbers(String input) {
        ValidationUtil.isValid(input);
        return input;
    }
}
