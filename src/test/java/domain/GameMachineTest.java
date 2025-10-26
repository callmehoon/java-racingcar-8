package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameMachineTest {
    private GameMachine gameMachine;
    private static final int FORWARD_CONDITION_EXAMPLE = 4;
    private static final int STOP_CONDITION_EXAMPLE = 2;

    @BeforeEach
    void setUp() {
        gameMachine = new GameMachine();
    }

    @Test
    @DisplayName("playRound(): 랜덤 값이 4 이상일 때만 전진")
    void 전진_및_정지_테스트() {
        gameMachine.setupCars(List.of("ALPHA", "BRAVO", "CHARLIE"));

        assertRandomNumberInRangeTest(() -> gameMachine.playRound(),
                FORWARD_CONDITION_EXAMPLE, STOP_CONDITION_EXAMPLE, FORWARD_CONDITION_EXAMPLE);

        assertThat(gameMachine.getMoveCounts()).containsExactly("-", "", "-");
    }

    @Test
    @DisplayName("getWinners(): 가장 많이 전진한 자동차 반환(단독우승)")
    void 단독_우승_반환_테스트() {
        gameMachine.setupCars(List.of("ALPHA", "BRAVO", "CHARLIE"));

        assertRandomNumberInRangeTest(() -> gameMachine.playRound(),
                FORWARD_CONDITION_EXAMPLE, STOP_CONDITION_EXAMPLE, FORWARD_CONDITION_EXAMPLE);
        assertRandomNumberInRangeTest(() -> gameMachine.playRound(),
                FORWARD_CONDITION_EXAMPLE, FORWARD_CONDITION_EXAMPLE, STOP_CONDITION_EXAMPLE);

        List<String> winners = gameMachine.getWinners();

        assertThat(winners).containsExactly("ALPHA");
    }

    @Test
    @DisplayName("getWinners(): 가장 많이 전진한 자동차 반환(공동우승)")
    void 공동_우승_반환_테스트() {
        gameMachine.setupCars(List.of("ALPHA", "BRAVO", "CHARLIE"));

        assertRandomNumberInRangeTest(() -> gameMachine.playRound(),
                FORWARD_CONDITION_EXAMPLE, STOP_CONDITION_EXAMPLE, FORWARD_CONDITION_EXAMPLE);
        assertRandomNumberInRangeTest(() -> gameMachine.playRound(),
                FORWARD_CONDITION_EXAMPLE, STOP_CONDITION_EXAMPLE, FORWARD_CONDITION_EXAMPLE);

        List<String> winners = gameMachine.getWinners();

        assertThat(winners).containsExactly("ALPHA", "CHARLIE");
    }
}