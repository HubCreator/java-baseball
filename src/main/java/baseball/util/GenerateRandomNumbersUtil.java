package baseball.util;

import baseball.enums.Const;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumbersUtil {

    private GenerateRandomNumbersUtil() {

    }

    public static List<Integer> generateRandomBalls() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Const.SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(Const.MIN.getValue(), Const.MAX.getValue());
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
