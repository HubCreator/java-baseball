package baseball.domain;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameManager {
    private final BaseBallGame baseBallGame;

    public GameManager(List<Integer> balls) {
        InputView.printStartMessage();
        baseBallGame = new BaseBallGame(Balls.create(balls));
    }

    public void run() {
        boolean flag;
        do {
            Balls playerBalls = Balls.create(InputView.readNumbers(Console.readLine()));
            flag = baseBallGame.play(playerBalls);
        } while (flag);

    }
}
