package baseball.domain;

import baseball.enums.BallStatus;

import java.util.List;
import java.util.Objects;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
                .map(m -> m.play(ball))
                .filter(m -> m == BallStatus.BALL || m == BallStatus.STRIKE)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
