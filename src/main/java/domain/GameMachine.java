package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameMachine {
    /*
    1. 각 자동차는 0~9 사이의 무작위 수를 생성한다.
    2. 무작위 값이 4 이상일 경우 전진(`-` 추가), 그렇지 않으면 멈춘다.
    3. 모든 시도 횟수만큼 경주를 반복 수행한다.
    4. 매 시도마다 각 자동차의 이름과 현재 전진 상태를 출력한다.
     */

    private List<String> carNames;
    private List<String> moveCounts;
    private static final int FORWARD_CONDITION = 4;

    public void setupCars(List<String> names) {
        this.carNames = names;
        this.moveCounts = new ArrayList<>(Collections.nCopies(names.size(), ""));
    }

    public void playRound() {
        if (carNames == null) {
            return;
        }

        for (int i = 0; i < carNames.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= FORWARD_CONDITION) {
                String currentMove = moveCounts.get(i);
                moveCounts.set(i, currentMove + "-");
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

        for (int i = 0; i < this.carNames.size(); i++) {
            if (moveCounts.get(i).length() == maxScore) {
                winners.add(carNames.get(i));
            }
        }

        return winners;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<String> getMoveCounts() {
        return moveCounts;
    }
}