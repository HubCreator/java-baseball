package baseball.enums;

public enum ConstVariable {
    MIN(1), MAX(9), SIZE(3);

    private final int value;

    ConstVariable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
