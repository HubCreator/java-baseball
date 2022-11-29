package baseball.enums;

public enum ConstVariable {
    ZERO(0), MIN(1), MAX(9), SIZE(3);

    private final int value;

    ConstVariable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isMatch(int input) {
        return value == input;
    }

    public static boolean isGreaterThanZero(int input) {
        return ZERO.value < input;
    }
}
