package baseball;

import baseball.domain.GameManager;

public class Application {
    public static void main(String[] args) {
        try {
            GameManager gameManager = new GameManager();
            gameManager.run();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력하셨습니다. 게임을 종료합니다.");
        }
    }
}
