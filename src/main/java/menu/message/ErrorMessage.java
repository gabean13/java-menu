package menu.message;

public class ErrorMessage {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String COACH_NAME_INVALID_ERROR = ERROR_PREFIX + "코치 이름은 2 ~ 4글자여야 합니다.";
    public static final String COACH_DUPLICATE_ERROR = ERROR_PREFIX + "코치 이름은 중복될 수 없습니다.";
    public static final String COACH_NUMBER_ERROR = ERROR_PREFIX + "코치는 2명 ~ 5명이어야 합니다.";
    public static final String INEDIBLE_FOOD_NUMBER_ERROR = ERROR_PREFIX + "못 먹는 음식은 2개 이상일 수 업습니다";
}
