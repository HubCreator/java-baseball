package baseball;

import baseball.domain.BaseBallGame;
import baseball.util.GenerateRandomNumbersUtil;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> balls = GenerateRandomNumbersUtil.generateRandomBalls();
        BaseBallGame baseBallGame = new BaseBallGame(balls);
        baseBallGame.play();
    }
}
