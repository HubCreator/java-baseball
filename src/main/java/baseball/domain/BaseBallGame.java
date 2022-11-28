package baseball.domain;


import baseball.enums.BallStatus;

import java.util.List;

public class BaseBallGame {
    private final Balls answer;

    public BaseBallGame(Balls balls) {
        this.answer = balls;
    }

    public void play(Balls userBalls) {
        List<BallStatus> result = answer.play(userBalls);

    }
}
