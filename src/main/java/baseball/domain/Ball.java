package baseball.domain;

import baseball.enums.BallStatus;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNumber;

    public Ball(int position, int ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ballNumber == ball.ballNumber) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
