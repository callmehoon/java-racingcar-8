package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMachine {
    /*
    1. 각 자동차는 0~9 사이의 무작위 수를 생성한다.
    2. 무작위 값이 4 이상일 경우 전진(`-` 추가), 그렇지 않으면 멈춘다.
    3. 모든 시도 횟수만큼 경주를 반복 수행한다.
    4. 매 시도마다 각 자동차의 이름과 현재 전진 상태를 출력한다.
     */

    private String[] carNames;
    private String[] moveCounts;
    private static final int FORWARD_CONDITION = 4;

    public void setupCars(String[] names) {
        this.carNames = names;
        this.moveCounts = new String[names.length];

        Arrays.fill(this.moveCounts, "");
    }

    public void playRound() {
        if (carNames == null) {
            return;
        }

        for (int i = 0; i < carNames.length; i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= FORWARD_CONDITION) {
                moveCounts[i] += "-";
            }
        }
    }

    public List<String> getWinners() {
        int maxScore = 0;
        List<String> winners = new ArrayList<>();

        for (String move : this.moveCounts) {
            if (move.length() > maxScore) {
                maxScore = move.length();
            }
        }

        for (int i = 0; i < this.carNames.length; i++) {
            if (this.moveCounts[i].length() == maxScore) {
                winners.add(this.carNames[i]);
            }
        }

        return winners;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public String[] getMoveCounts() {
        return moveCounts;
    }
}