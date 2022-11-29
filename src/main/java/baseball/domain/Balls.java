package baseball.domain;

import baseball.enums.BallStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balls implements Iterable<Ball>{
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


    public List<BallStatus> play(Balls balls) {
        return BallStatus.play(answer, balls);
    }

    public BallStatus play(Ball ball) {
        return BallStatus.play(answer, ball);
    }

    @Override
    public Iterator<Ball> iterator() {
        return answer.iterator();
    }
}
