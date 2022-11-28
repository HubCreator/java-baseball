package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GenerateRandomNumbersUtil {

    private GenerateRandomNumbersUtil() {

    }

    public static List<Integer> generateRandomBalls(int count, int minValue, int maxValue) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < count) {
            int randomNumber = Randoms.pickNumberInRange(minValue, maxValue);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
