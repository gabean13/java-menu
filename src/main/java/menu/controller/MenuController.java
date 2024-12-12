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
        //1. 코치 정보 입력
        List<Coach> coaches = initCoach();
        //2. 메뉴 생성
        RecommendMenu recommendMenu = recommendMenuService.getRecommendMenu(coaches);
        //4. 메뉴 출력
        outputView.printMenu(recommendMenu);
    }

    private List<Coach> initCoach() {
        //1. 코치 이름 입력
        String nameInput = inputview.getCoachNames();
        List<Coach> coaches = initCoachInfoService.saveCoachNames(nameInput);
        //2. 코치 별 못먹는 메뉴 입력
        for (Coach coach : coaches) {
            String inEdibleFoodInput = inputview.getInedibleFood(coach.getName());
            initCoachInfoService.saveInedibleFoods(coach, inEdibleFoodInput);
        }

        return coaches;
    }
}
