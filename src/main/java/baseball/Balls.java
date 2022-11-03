package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    public static final int BALL_CNT = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> ballNums) {
        this.balls = mapIntToBall(ballNums);
    }

    private List<Ball> mapIntToBall(List<Integer> ballNums) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < BALL_CNT; i++) {
            result.add(new Ball(i, ballNums.get(i)));
        }
        return result;
    }

    public BallStatus play(Ball ball) {
        return balls.stream().map(m -> m.play(ball))
                .filter(status -> status != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public Result play(List<Integer> ballNums) {
        Balls userBalls = new Balls(ballNums);
        Result result = new Result();

        for (Ball ball : balls) {
            BallStatus status = userBalls.play(ball);
            result.report(status);
        }

        return result;
    }
}

