package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private final Balls answer;

    public BaseBallGame(List<Integer> balls) {
        answer = new Balls(mapBalls(balls));
    }

    private List<Ball> mapBalls(List<Integer> balls) {
        List<Ball> result = new ArrayList<>();
        int index = 0;
        for (Integer ball : balls) {
            result.add(new Ball(index++, ball));
        }
        return result;
    }

    public void play() {

    }
}
