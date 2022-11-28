package baseball.domain;

import baseball.enums.BallStatus;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Balls {
    private final List<Ball> answer;

    public Balls(List<Ball> balls) {
        this.answer = balls;
    }

    public BallStatus play(Ball ball) {
        return answer.stream()
                .map(m -> m.play(ball))
                .filter(m -> m == BallStatus.BALL || m == BallStatus.STRIKE)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public List<BallStatus> play(Balls balls) {
        return balls.answer.stream()
                .map(ball -> play(ball))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls ball = (Balls) o;
        return Objects.equals(answer, ball.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }
}
