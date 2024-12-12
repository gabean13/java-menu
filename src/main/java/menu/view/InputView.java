package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;
import java.util.List;
import menu.message.GuideMessage;
import menu.model.Coach;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String getCoachNames() {
        print(GuideMessage.START_MENU_SYSTEM);
        while(true) {
            try {
                print(GuideMessage.COACH_NAME_GUIDE);
                String input = Console.readLine();
                inputValidator.isCoachNamesValid(input);
                return input;
            } catch (IllegalArgumentException ex) {
                print(ex.getMessage());
            }
        }
    }

    public String getInedibleFood(String name) {
        while(true) {
            try {
                print(MessageFormat.format(GuideMessage.COACH_INEDIBLE_FOOD_GUIDE, name));
                String input = Console.readLine();
                inputValidator.isInedibleFoodValid(input);
                return input;
            } catch (IllegalArgumentException ex) {
                print(ex.getMessage());
            }
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}
