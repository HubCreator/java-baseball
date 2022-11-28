package baseball.enums;

public enum Const {
    MIN(1), MAX(9), SIZE(3);

    private final int value;

    Const(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
