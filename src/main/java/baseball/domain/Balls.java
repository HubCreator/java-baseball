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

    public static Balls create(String string) {
        List<Ball> result = new ArrayList<>();
        int index = START_INDEX;
        while (index < string.length()) {
            result.add(new Ball(index, string.charAt(index) - '0'));
            index++;
        }
        return new Balls(result);
    }

    public static Balls create(List<Integer> list) {
        List<Ball> result = new ArrayList<>();
        int index = START_INDEX;
        for (Integer number : list) {
            result.add(new Ball(index++, number));
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
