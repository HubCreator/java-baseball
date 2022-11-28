package baseball;

public enum RetryOrQuit {
    RETRY("1"), QUIT("2");

    private final String value;

    RetryOrQuit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isRetry(String input) {
        return this.value.equals(input);
    }

    public boolean isQuit(String input) {
        return this.value.equals(input);
    }
}
