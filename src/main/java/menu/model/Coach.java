package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> inedibleMenu;

    public Coach(String name) {
        this.name = name;
        this.inedibleMenu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<String> getInedibleMenu() {
        return inedibleMenu;
    }

    public void updateInedibleMenu(String input) {
        if(input == null || input.isEmpty()) {
            return;
        }

        for(String menu : input.split(",")) {
            inedibleMenu.add(menu);
        }
    }
}
