package menu.controller;

import java.util.List;
import menu.model.Coach;
import menu.model.RecommendMenu;
import menu.service.InitCoachInfoService;
import menu.service.RecommendMenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputview;
    private final OutputView outputView;
    private final InitCoachInfoService initCoachInfoService;
    private final RecommendMenuService recommendMenuService;

    public MenuController(InputView inputview, OutputView outputView,
                          InitCoachInfoService initCoachInfoService,
                          RecommendMenuService recommendMenuService) {
        this.inputview = inputview;
        this.outputView = outputView;
        this.initCoachInfoService = initCoachInfoService;
        this.recommendMenuService = recommendMenuService;
    }

    public void run() {
        List<Coach> coaches = initCoach();
        RecommendMenu recommendMenu = recommendMenuService.getRecommendMenu(coaches);
        outputView.printMenu(recommendMenu);
    }

    private List<Coach> initCoach() {
        String nameInput = inputview.getCoachNames();
        List<Coach> coaches = initCoachInfoService.saveCoachNames(nameInput);

        for (Coach coach : coaches) {
            String inEdibleFoodInput = inputview.getInedibleFood(coach.getName());
            initCoachInfoService.saveInedibleFoods(coach, inEdibleFoodInput);
        }

        return coaches;
    }
}
