package menu.view;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import menu.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @DisplayName("정상적으로 코치 이름을 입력")
    @ParameterizedTest
    @ValueSource(strings = {"안녕1,안녕2,안녕3", "안녕1,안녕2", "안녕1,안녕2,안녕3,안녕4,안녕5"})
    void isCoachNamesValidTest(String input) {
        assertThatCode(() -> {
            inputValidator.isCoachNamesValid(input);
        }).doesNotThrowAnyException();
    }

    @DisplayName("코치 이름이 2~4글자가 아닌 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"abcde,efghi,jklmnop", "a,abc,abcd", ",abc,abd"})
    void isCoachNamesValidTest1(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.isCoachNamesValid(input);
        }).withMessage(ErrorMessage.COACH_NAME_INVALID_ERROR);
    }

    @DisplayName("코치 인원이 2~5명이 아닌 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"11", "11,22,33,44,55,66"})
    void isCoachNamesValidTest2(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.isCoachNamesValid(input);
        }).withMessage(ErrorMessage.COACH_NUMBER_ERROR);
    }

    @DisplayName("코치 이름이 중복 되는 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"11,22,33,11", "11,11"})
    void isCoachNamesValidTest3(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.isCoachNamesValid(input);
        }).withMessage(ErrorMessage.COACH_DUPLICATE_ERROR);
    }

    @DisplayName("정상적으로 못 먹는 음식을 입력")
    @ParameterizedTest
    @ValueSource(strings = {"우동,스키야끼", "우동", "\n", "", " "})
    void isInedibleFoodValidTest(String input) {
        assertThatCode(() -> {
            inputValidator.isInedibleFoodValid(input);
        }).doesNotThrowAnyException();
    }


    @DisplayName("못 먹는 음식이 2개 이상인 경우 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"음식1,음식2,음식3", "음식12,음식234,음식546,음식123"})
    void isInedibleFoodValidTest1(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputValidator.isInedibleFoodValid(input);
        }).withMessage(ErrorMessage.INEDIBLE_FOOD_NUMBER_ERROR);
    }
}