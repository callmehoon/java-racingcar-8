package validate;

public class Validator {
    /*
    1. 자동차 이름은 5자 이하만 허용
    2. 이름이 비어 있거나 공백만 있는 경우 예외 처리
    3. 시도 횟수가 1회 이상인지 검증
     */

    public void validatePlayersName(String[] playersTokens) {
        for (String token : playersTokens) {
            if (token.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 설정해야 합니다.");
            }
            if (token.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 비어 있을 수 없습니다.");
            }
        }
    }

    public void validatePlayTimes(int playTimes) {
        if (playTimes < 1) {
            throw new IllegalArgumentException("시도할 횟수는 1회 이상으로 설정해야 합니다.");
        }
    }
}
