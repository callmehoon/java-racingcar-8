package view;

import java.util.List;

public class OutputView {
    /*
    1. 매 시도마다 각 자동차의 이름과 현재 전진 상태를 출력한다.
    2. 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력한다.
    3. 최종 결과 문구 `"최종 우승자 : 이름"`을 출력한다.
     */

    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<String> carNames, List<String> moveCounts) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.println(carNames.get(i) + " : " + moveCounts.get(i));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
