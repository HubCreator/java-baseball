package baseball.domain;


import baseball.enums.BallStatus;
import baseball.enums.Const;

import java.util.List;

public class BaseBallGame {
    private final Balls answer;
    private List<BallStatus> result;

    public BaseBallGame(Balls balls) {
        this.answer = balls;
    }

    public void play(Balls userBalls) {
        result = answer.play(userBalls);
    }

    public boolean isOver() {
        return result.stream().filter(m -> m == BallStatus.STRIKE).count() == Const.SIZE.getValue();
    }
}
