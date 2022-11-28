package baseball.domain;

import baseball.enums.BallStatus;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private final Balls answer;

    public BaseBallGame(List<Integer> balls) {
        answer = mapBalls(balls);
    }

    public void play() {
        String input = InputView.readNumbers(Console.readLine());
        Balls playerBalls = mapBalls(input);
        List<BallStatus> result = answer.play(playerBalls);
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
