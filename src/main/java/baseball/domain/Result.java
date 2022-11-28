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
        if (BallStatus.STRIKE.isMatch(ballStatus)) {
            strikeCount++;
        }
    }

    private void isBall(BallStatus ballStatus) {
        if (BallStatus.BALL.isMatch(ballStatus)) {
            ballCount++;
        }
    }

    public boolean isOver() {
        return ConstVariable.SIZE.isMatch(strikeCount);
    }

    @Override
    public String toString() {
        if (ConstVariable.SIZE.isMatch(strikeCount)) {
            return ViewMessage.END_MESSAGE.getValue();
        }
        if (ConstVariable.ZERO.isMatch(strikeCount) && ConstVariable.ZERO.isMatch(ballCount)) {
            return MessageFormat.format(ViewMessage.N_BALL_N_STRIKE.getValue(), ballCount, strikeCount);
        }
        if (ConstVariable.ZERO.isMatch(strikeCount)) {
            return MessageFormat.format(ViewMessage.N_STRIKE.getValue(), strikeCount);
        }
        if (ConstVariable.ZERO.isMatch(ballCount)) {
            return MessageFormat.format(ViewMessage.N_BALL.getValue(), ballCount);
        }
        return ViewMessage.NOTHING.getValue();
    }
}
