package racingcar;

import validate.Validator;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Validator validator = new Validator();

        String[] players = inputView.setPlayers();
        validator.validatePlayersName(players);
        int playTimes = inputView.setPlayTimes();
        validator.validatePlayTimes(playTimes);
    }
}
