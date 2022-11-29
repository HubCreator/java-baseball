package baseball.view;

import baseball.domain.Result;

public class OutputView {

    public static void printResult(Result result) {
        System.out.println(result.toString());
    }
}
