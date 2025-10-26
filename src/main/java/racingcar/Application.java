package racingcar;

import domain.GameMachine;
import validate.Validator;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Validator validator = new Validator();
        GameMachine gameMachine = new GameMachine();

        String[] players = inputView.setPlayers();
        validator.validatePlayersName(players);
        int playTimes = inputView.setPlayTimes();
        validator.validatePlayTimes(playTimes);

        gameMachine.setupCars(players);
        for (int i = 0; i < playTimes; i++) {
            gameMachine.playRound();
        }
        gameMachine.getWinners();
    }
}
