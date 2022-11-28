package baseball.domain;


public class BaseBallGame {
    private final Balls answer;

    public BaseBallGame(Balls balls) {
        this.answer = balls;
    }

    boolean play(Balls userBalls) {
        Result result = new Result(answer.play(userBalls));
        return result.isOver();
    }
}
