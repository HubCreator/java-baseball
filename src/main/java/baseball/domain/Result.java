package baseball.domain;

import baseball.enums.BallStatus;
import baseball.enums.Const;

import java.util.List;

public class Result {
    private final List<BallStatus> result;

    public Result(List<BallStatus> result) {
        this.result = result;

    }

    public boolean isOver() {
        return result
                .stream()
                .filter(m -> m == BallStatus.STRIKE).count() == Const.SIZE.getValue();
    }
}
