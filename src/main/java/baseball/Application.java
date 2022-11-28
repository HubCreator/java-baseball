package baseball;

import baseball.domain.GameManager;
import baseball.util.GenerateRandomNumbersUtil;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            List<Integer> balls = GenerateRandomNumbersUtil.generateRandomBalls();
            GameManager gameManager = new GameManager(balls);
            gameManager.run();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하셨습니다. 게임을 종료합니다.");
        }
    }
}
