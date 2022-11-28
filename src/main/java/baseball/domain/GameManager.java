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
        do {
            Balls playerBalls = Balls.create(InputView.readNumbers());
            OutputView.printResult(baseBallGame.play(playerBalls));
        } while (!baseBallGame.isOver() || InputView.retryOrNot());

    }
}
