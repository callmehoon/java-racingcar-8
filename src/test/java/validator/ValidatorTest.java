package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("예외 발생: 자동차 이름이 5자 초과")
    void 이름_5자_초과() {
        List<String> players = List.of("ALPHA", "BRAVO", "CHARLIE");

        assertThatThrownBy(() -> validator.validatePlayersName(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로 설정해야 합니다.");
    }

    @Test
    @DisplayName("예외 발생: 자동차 이름이 비어있음")
    void 이름_비어있음() {
        List<String> players = List.of("ALPHA", "BRAVO", "");

        assertThatThrownBy(() -> validator.validatePlayersName(players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름이 비어 있을 수 없습니다.");
    }

    @Test
    @DisplayName("예외 발생: 시도 횟수 1 미만")
    void 시도_횟수_1_미만() {
        int playTimes = 0;

        assertThatThrownBy(() -> validator.validatePlayTimes(playTimes))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1회 이상으로 설정해야 합니다.");
    }
}
