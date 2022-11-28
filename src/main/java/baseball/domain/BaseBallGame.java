package baseball.domain;


public class BaseBallGame {
    private final Balls answer;

    public BaseBallGame(Balls balls) {
        this.answer = balls;
    }

    Result play(Balls userBalls) {
        return new Result(answer.play(userBalls));
    }
}
