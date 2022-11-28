package baseball.domain;

import baseball.enums.BallStatus;
import baseball.enums.ConstVariable;
import baseball.enums.ViewMessage;

import java.text.MessageFormat;
import java.util.List;

public class Result {
    private int ballCount = 0;
    private int strikeCount = 0;

    public Result(List<BallStatus> result) {
        for (BallStatus ballStatus : result) {
            isStrike(ballStatus);
            isBall(ballStatus);
        }
    }

    private void isStrike(BallStatus ballStatus) {
        if (ballStatus == BallStatus.STRIKE) {
            strikeCount++;
        }
    }

    private void isBall(BallStatus ballStatus) {
        if (ballStatus == BallStatus.BALL) {
            ballCount++;
        }
    }

    public boolean isOver() {
        return strikeCount == ConstVariable.SIZE.getValue();
    }

    @Override
    public String toString() {
        if (strikeCount == ConstVariable.SIZE.getValue()) {
            return ViewMessage.END_MESSAGE.getValue();
        }
        if (strikeCount > 0 && ballCount > 0) {
            return MessageFormat.format(ViewMessage.N_BALL_N_STRIKE.getValue(), ballCount, strikeCount);
        }
        if (strikeCount > 0) {
            return MessageFormat.format(ViewMessage.N_STRIKE.getValue(), strikeCount);
        }
        if (ballCount > 0) {
            return MessageFormat.format(ViewMessage.N_BALL.getValue(), ballCount);
        }
        return ViewMessage.NOTHING.getValue();
    }
}
