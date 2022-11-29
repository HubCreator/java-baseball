package baseball.domain;

import baseball.enums.BallStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {
    public static final int START_INDEX = 0;

    private final List<Ball> answer;

    public Balls(List<Ball> balls) {
        this.answer = balls;
    }

    public static Balls create(String input) {
        List<Ball> result = new ArrayList<>();
        for (int index = START_INDEX; index < input.length(); index++) {
            result.add(new Ball(index, input.charAt(index) - '0'));
        }
        return new Balls(result);
    }

    public static Balls create(List<Integer> input) {
        List<Ball> result = new ArrayList<>();
        for (int index = START_INDEX; index < input.size(); index++) {
            result.add(new Ball(index, input.get(index)));
        }
        return new Balls(result);
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
}
