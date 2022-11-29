package baseball.enums;

import baseball.domain.Ball;
import baseball.domain.Balls;

import java.util.ArrayList;
import java.util.List;

public enum BallStatus {
    NOTHING, STRIKE, BALL;

    public static List<BallStatus> play(List<Ball> answer, Balls userBalls) {
        List<BallStatus> result = new ArrayList<>();
        for (Ball ball : userBalls) {
            result.add(play(answer, ball));
        }
        return result;
    }

    public static BallStatus play(List<Ball> answer, Ball ball) {
        return answer.stream()
                .map(m -> m.play(ball))
                .filter(m -> m == BallStatus.BALL || m == BallStatus.STRIKE)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public boolean isMatch(BallStatus ballStatus) {
        return this == ballStatus;
    }
}
