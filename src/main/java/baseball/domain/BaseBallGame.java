package baseball.domain;

public class BaseBallGame {
    private final Balls answer;
    private Result result;

    public BaseBallGame(Balls balls) {
        this.answer = balls;
    }

    public Result play(Balls userBalls) {
        return result = new Result(answer.play(userBalls));
    }

    public boolean isOver() {
        return result.isOver();
    }
}
