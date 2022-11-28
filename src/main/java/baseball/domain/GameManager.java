package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameManager {
    private final BaseBallGame baseBallGame;

    public GameManager(List<Integer> balls) {
        InputView.printStartMessage();
        baseBallGame = new BaseBallGame(Balls.create(balls));
    }

    public void run() {
        Result result;
        do {
            String input = InputView.readNumbers();
            Balls playerBalls = Balls.create(input);
            result = baseBallGame.play(playerBalls);
            OutputView.printResult(result);
        } while (!result.isOver() || InputView.retryOrNot());

    }
}
