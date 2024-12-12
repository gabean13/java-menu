package menu;

import menu.controller.MenuController;
import menu.service.InitCoachInfoService;
import menu.service.RecommendMenuService;
import menu.view.InputValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class ApplicationConfig {
    public MenuController createMenuController() {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();

        InitCoachInfoService initCoachInfoService = new InitCoachInfoService();
        RecommendMenuService recommendMenuService = new RecommendMenuService();

        return new MenuController(inputView, outputView, initCoachInfoService, recommendMenuService);
    }
}
