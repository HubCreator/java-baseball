package baseball;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.enums.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    @DisplayName("공 하나에 대한 테스트")
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

    @DisplayName("여러 개의 공에 대한 테스트")
    @Nested
    class MultipleTest {
        Balls computer;

        @BeforeEach
        void init() {
            List<Ball> balls = Arrays.asList(
                    new Ball(1, 1),
                    new Ball(2, 2),
                    new Ball(3, 3));
            computer = new Balls(balls);
        }

        @DisplayName("낫싱")
        @Test
        void case1() {
            assertThat(computer.play(new Ball(1, 5))).isEqualTo(BallStatus.NOTHING);
            assertThat(computer.play(new Ball(2, 6))).isEqualTo(BallStatus.NOTHING);
        }

        @DisplayName("볼")
        @Test
        void case2() {
            assertThat(computer.play(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
            assertThat(computer.play(new Ball(2, 3))).isEqualTo(BallStatus.BALL);
        }

        @DisplayName("스트라이크")
        @Test
        void case3() {
            assertThat(computer.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
            assertThat(computer.play(new Ball(2, 2))).isEqualTo(BallStatus.STRIKE);
        }

    }
}
