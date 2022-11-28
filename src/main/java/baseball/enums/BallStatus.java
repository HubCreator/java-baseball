package baseball.enums;

public enum BallStatus {
    NOTHING, STRIKE, BALL;

    public boolean isMatch(BallStatus ballStatus) {
        return this == ballStatus;
    }
}
