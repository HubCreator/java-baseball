package baseball.gameTest;

import baseball.domain.Ball;
import baseball.enums.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컴퓨터 공 하나, 사용자 공 하나에 대한 테스트")
@Nested
class SingleTest {
    Ball computer;

    @BeforeEach
    void init() {
        computer = new Ball(1, 3);
    }

    @DisplayName("낫싱")
    @Test
    void case1() {
        assertThat(computer.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
        assertThat(computer.play(new Ball(1, 5))).isEqualTo(BallStatus.NOTHING);
    }

    @DisplayName("볼")
    @Test
    void case2() {
        assertThat(computer.play(new Ball(2, 3))).isEqualTo(BallStatus.BALL);
    }

    @DisplayName("스트라이크")
    @Test
    void case3() {
        assertThat(computer.play(new Ball(1, 3))).isEqualTo(BallStatus.STRIKE);
    }
}