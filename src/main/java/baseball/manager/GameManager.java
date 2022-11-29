package baseball.manager;

import baseball.domain.Balls;
import baseball.domain.BaseBallGame;
import baseball.domain.Result;
import baseball.enums.ConstVariable;
import baseball.util.GenerateRandomNumbersUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameManager {
    private BaseBallGame baseBallGame;

    public GameManager() {
        InputView.printStartMessage();
    }

    public void run() {
        do {
            List<Integer> balls = getRandomBalls();
            baseBallGame = new BaseBallGame(Balls.create(balls));
        } while (canPlay());
    }

    private boolean canPlay() {
        do {
            Balls playerBalls = Balls.create(InputView.readNumbers());
            Result result = baseBallGame.play(playerBalls);
            OutputView.printResult(result);
        } while (!baseBallGame.isOver());

        return InputView.retryOrNot();
    }

    private List<Integer> getRandomBalls() {
        return GenerateRandomNumbersUtil.generateRandomBalls(
                ConstVariable.SIZE.getValue(),
                ConstVariable.MIN.getValue(),
                ConstVariable.MAX.getValue());
    }
}
