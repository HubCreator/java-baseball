package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationUtilTest {

    @DisplayName("1-9 범위 내의 숫자이다.")
    @Nested
    class ValidRange {

        @DisplayName("범위 내의 입력")
        @ValueSource(strings = {"1", "3", "9"})
        @ParameterizedTest
        void case1(String input) {
            ValidationUtil.isValidRange(input);
        }

        @DisplayName("범위를 초과한 입력")
        @ValueSource(strings = {"0", "10", "999999999999999999999999999999", "!", "*"})
        @ParameterizedTest
        void case2(String input) {
            assertThatThrownBy(() -> ValidationUtil.isValidRange(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("세 개의 숫자이면서, 중복되지 않았다.")
    @Nested
    class ValidInput {

        @DisplayName("세 개의 숫자")
        @ValueSource(strings = {"123", "358", "789"})
        @ParameterizedTest
        void case1(String input) {
            ValidationUtil.isValidSize(input);
        }

        @DisplayName("세 개의 숫자가 아님")
        @ValueSource(strings = {"1234", "35", "78910", "1"})
        @ParameterizedTest
        void case2(String input) {
            assertThatThrownBy(() -> ValidationUtil.isValidSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("세 개의 숫자가 중복되지 않음")
        @ValueSource(strings = {"123", "235", "789"})
        @ParameterizedTest
        void case3(String input) {
            ValidationUtil.isDistinct(input);
        }

        @DisplayName("세 개의 숫자 중 중복이 있음")
        @ValueSource(strings = {"122", "233", "799"})
        @ParameterizedTest
        void case4(String input) {
            assertThatThrownBy(() -> ValidationUtil.isDistinct(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}