package baseball.enums;

public enum RetryOrQuit {
    RETRY("1"), QUIT("2");

    private final String value;

    RetryOrQuit(String value) {
        this.value = value;
    }

    public boolean isMatch(String input) {
        return value.equals(input);
    }

    public String getValue() {
        return value;
    }
}
