package validator;

import java.util.List;

public class Validator {
    /*
    1. 자동차 이름은 5자 이하만 허용
    2. 이름이 비어 있거나 공백만 있는 경우 예외 처리
    3. 시도 횟수가 1회 이상인지 검증
     */

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_PLAY_TIMES = 1;

    public void validatePlayersName(List<String> playersTokens) {
        for (String token : playersTokens) {
            if (token.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 설정해야 합니다.");
            }
            if (token.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 비어 있을 수 없습니다.");
            }
        }
    }

    public void validatePlayTimes(int playTimes) {
        if (playTimes < MIN_PLAY_TIMES) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상으로 설정해야 합니다.");
        }
    }
}
