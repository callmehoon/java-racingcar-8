package racingcar;

import domain.GameMachine;
import java.util.List;
import validator.Validator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Validator validator = new Validator();
        GameMachine gameMachine = new GameMachine();
        OutputView outputView = new OutputView();

        String[] players = inputView.setPlayers();
        validator.validatePlayersName(players);
        int playTimes = inputView.setPlayTimes();
        validator.validatePlayTimes(playTimes);

        gameMachine.setupCars(players);
        outputView.printStartMessage();
        for (int i = 0; i < playTimes; i++) {
            gameMachine.playRound();
            outputView.printRoundResult(gameMachine.getCarNames(), gameMachine.getMoveCounts());
        }

        List<String> winners = gameMachine.getWinners();
        outputView.printWinners(winners);
    }
}
