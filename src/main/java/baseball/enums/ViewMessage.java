package baseball.enums;

public enum ViewMessage {
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    N_BALL_N_STRIKE("{0}볼 {1}스트라이크 "),
    N_BALL("{0}볼 "),
    N_STRIKE("{0}스트라이크 "),
    NOTHING("낫싱 "),
    END_MESSAGE(String.format("\n%d개의 숫자를 모두 맞히셨습니다! 게임 종료", ConstVariable.SIZE.getValue())),
    RETRY_OR_QUIT_MESSAGE(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RetryOrQuit.RETRY.getValue(), RetryOrQuit.QUIT.getValue()));

    private final String value;

    ViewMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
