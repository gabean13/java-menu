package menu.service;

import java.util.ArrayList;
import java.util.List;
import menu.model.Coach;

public class InitCoachInfoService {
    public List<Coach> saveCoachNames(String nameInput) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : nameInput.split(",")) {
            coaches.add(new Coach(name.trim()));
        }

        return coaches;
    }

    public void saveInedibleFoods(Coach coach, String inEdibleFoodInput) {
        coach.updateInedibleMenu(inEdibleFoodInput);
    }
}
