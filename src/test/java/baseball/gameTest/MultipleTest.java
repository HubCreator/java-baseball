package baseball.gameTest;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.enums.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컴퓨터 공 여러 개일 때의 테스트")
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

    @DisplayName("컴퓨터 공 여러 개, 사용자 공 하나에 대한 테스트")
    @Nested
    class ComputerBalls_UserBall {

        @DisplayName("낫싱")
        @ValueSource(ints = {5, 6, 7, 8})
        @ParameterizedTest
        void case1(Integer input) {
            assertThat(computer.play(new Ball(1, input))).isEqualTo(BallStatus.NOTHING);
        }

        @DisplayName("볼")
        @ValueSource(ints = {2, 3})
        @ParameterizedTest
        void case2(Integer input) {
            assertThat(computer.play(new Ball(1, input))).isEqualTo(BallStatus.BALL);
        }

        @DisplayName("스트라이크")
        @Test
        void case3() {
            assertThat(computer.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
        }
    }

    @DisplayName("컴퓨터 공 여러 개, 사용자 공 여러 개에 대한 테스트")
    @Nested
    class ComputerBalls_UserBalls {

        @DisplayName("낫싱")
        @Test
        void case1() {
            List<Ball> balls = Arrays.asList(
                    new Ball(1, 4),
                    new Ball(2, 5),
                    new Ball(3, 6));
            Balls userBalls = new Balls(balls);
            List<BallStatus> result = computer.play(userBalls);
            assertThat(result.stream().filter(m -> m == BallStatus.NOTHING).count()).isEqualTo(3);
        }

        @DisplayName("N볼")
        @Nested
        class BallTest {
            @DisplayName("1볼")
            @Test
            void case2() {
                List<Ball> balls = Arrays.asList(
                        new Ball(1, 4),
                        new Ball(2, 5),
                        new Ball(3, 1));
                Balls userBalls = new Balls(balls);
                List<BallStatus> result = computer.play(userBalls);
                assertThat(result.stream().filter(m -> m == BallStatus.BALL).count()).isEqualTo(1);
            }

            @DisplayName("2볼")
            @Test
            void case3() {
                List<Ball> balls = Arrays.asList(
                        new Ball(1, 3),
                        new Ball(2, 5),
                        new Ball(3, 1));
                Balls userBalls = new Balls(balls);
                List<BallStatus> result = computer.play(userBalls);
                assertThat(result.stream().filter(m -> m == BallStatus.BALL).count()).isEqualTo(2);
            }

            @DisplayName("3볼")
            @Test
            void case4() {
                List<Ball> balls = Arrays.asList(
                        new Ball(1, 2),
                        new Ball(2, 3),
                        new Ball(3, 1));
                Balls userBalls = new Balls(balls);
                List<BallStatus> result = computer.play(userBalls);
                assertThat(result.stream().filter(m -> m == BallStatus.BALL).count()).isEqualTo(3);
            }
        }

        @DisplayName("N스트라이크")
        @Nested
        class Strike {

            @DisplayName("1스트라이크")
            @Test
            void case1() {
                List<Ball> balls = Arrays.asList(
                        new Ball(1, 1),
                        new Ball(2, 4),
                        new Ball(3, 5));
                Balls userBalls = new Balls(balls);
                List<BallStatus> result = computer.play(userBalls);
                assertThat(result.stream().filter(m -> m == BallStatus.STRIKE).count()).isEqualTo(1);
            }

            @DisplayName("2스트라이크")
            @Test
            void case2() {
                List<Ball> balls = Arrays.asList(
                        new Ball(1, 1),
                        new Ball(2, 2),
                        new Ball(3, 5));
                Balls userBalls = new Balls(balls);
                List<BallStatus> result = computer.play(userBalls);
                assertThat(result.stream().filter(m -> m == BallStatus.STRIKE).count()).isEqualTo(2);
            }

            @DisplayName("3스트라이크")
            @Test
            void case3() {
                List<Ball> balls = Arrays.asList(
                        new Ball(1, 1),
                        new Ball(2, 2),
                        new Ball(3, 3));
                Balls userBalls = new Balls(balls);
                List<BallStatus> result = computer.play(userBalls);
                assertThat(result.stream().filter(m -> m == BallStatus.STRIKE).count()).isEqualTo(3);
            }
        }
    }

    @DisplayName("N볼 N스트라이크")
    @Nested
    class BallAndStrike {

        @DisplayName("1볼 1스트라이크")
        @Test
        void case1() {
            List<Ball> balls = Arrays.asList(
                    new Ball(1, 1),
                    new Ball(2, 3),
                    new Ball(3, 5));
            Balls userBalls = new Balls(balls);
            List<BallStatus> result = computer.play(userBalls);
            assertThat(result.stream().filter(m -> m == BallStatus.BALL).count()).isEqualTo(1);
            assertThat(result.stream().filter(m -> m == BallStatus.STRIKE).count()).isEqualTo(1);
        }

        @DisplayName("2볼 1스트라이크")
        @Test
        void case2() {
            List<Ball> balls = Arrays.asList(
                    new Ball(1, 1),
                    new Ball(2, 3),
                    new Ball(3, 2));
            Balls userBalls = new Balls(balls);
            List<BallStatus> result = computer.play(userBalls);
            assertThat(result.stream().filter(m -> m == BallStatus.BALL).count()).isEqualTo(2);
            assertThat(result.stream().filter(m -> m == BallStatus.STRIKE).count()).isEqualTo(1);
        }
    }
}
