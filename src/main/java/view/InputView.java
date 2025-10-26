package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    /*
    1. 경주할 자동차 이름을 입력받는다. (쉼표(,) 기준으로 구분)
    2. 시도할 횟수를 입력받는다.
    3. 사용자 입력은 Console.readLine()을 이용한다.
     */

    public List<String> setPlayers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String players = Console.readLine();

        return List.of(players.split("[,]"));
    }

    public int setPlayTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return Integer.parseInt(Console.readLine());
    }
}
