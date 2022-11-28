package baseball.domain;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private BaseBallGame baseBallGame;

    public GameManager(List<Integer> balls) {
        baseBallGame = new BaseBallGame(mapBalls(balls));
    }

    public void run() {
        while (true) {
            Balls playerBalls = mapBalls(InputView.readNumbers(Console.readLine()));
            baseBallGame.play(playerBalls);
        }
    }

    private Balls mapBalls(List<Integer> balls) {
        List<Ball> result = new ArrayList<>();
        int index = 0;
        for (Integer ball : balls) {
            result.add(new Ball(index++, ball));
        }
        return new Balls(result);
    }

    private Balls mapBalls(String string) {
        List<Ball> result = new ArrayList<>();
        int index = 0;
        while (index < string.length()) {
            result.add(new Ball(index, string.charAt(index) - '0'));
            index++;
        }
        return new Balls(result);
    }
}
