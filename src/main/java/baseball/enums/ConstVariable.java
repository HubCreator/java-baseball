package baseball.enums;

public enum ConstVariable {
    MORE_THAN_ONE(0), MIN(1), MAX(9), SIZE(3);

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

    public static boolean isMoreThanOne(int input) {
        return MORE_THAN_ONE.value < input;
    }
}
