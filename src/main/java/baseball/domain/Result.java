package baseball.domain;

import baseball.enums.BallStatus;
import baseball.enums.ConstVariable;

import java.util.List;

public class Result {
    private final List<BallStatus> result;

    public Result(List<BallStatus> result) {
        this.result = result;

    }

    public boolean isOver() {
        return result
                .stream()
                .filter(m -> m == BallStatus.STRIKE).count() == ConstVariable.SIZE.getValue();
    }
}
