package menu.view;

import java.util.HashSet;
import java.util.Set;
import menu.message.ErrorMessage;

public class InputValidator {
    public void isCoachNamesValid(String input) {
        Set<String> names = checkFormatAndDuplicateValid(input.split(","));

        if(names.size() < 2 || names.size() > 5) {
            throw new IllegalArgumentException(ErrorMessage.COACH_NUMBER_ERROR);
        }
    }

    private static Set<String> checkFormatAndDuplicateValid(String[] nameInputs) {
        Set<String> names = new HashSet<>();
        for(String name : nameInputs) {
            if(name.length() < 2 || name.length() > 4) {
                throw new IllegalArgumentException(ErrorMessage.COACH_NAME_INVALID_ERROR);
            }
            if(names.contains(name)) {
                throw new IllegalArgumentException(ErrorMessage.COACH_DUPLICATE_ERROR);
            }
            names.add(name);
        }
        return names;
    }

    public void isInedibleFoodValid(String input) {
        if(input == null || input.isBlank()) {
            return;
        }

        if(input.split(",").length > 2) {
            throw new IllegalArgumentException(ErrorMessage.INEDIBLE_FOOD_NUMBER_ERROR);
        }
    }
}
