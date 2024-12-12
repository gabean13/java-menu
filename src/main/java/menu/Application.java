package menu;

import menu.controller.MenuController;

public class Application {
    private final MenuController menuController;

    public Application() {
        this.menuController = new ApplicationConfig().createMenuController();
    }

    public static void main(String[] args) {
        new Application().menuController.run();
    }
}
