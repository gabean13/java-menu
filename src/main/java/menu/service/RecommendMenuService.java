package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.model.Category;
import menu.model.Coach;
import menu.model.RecommendMenu;

public class RecommendMenuService {
    public RecommendMenu getRecommendMenu(List<Coach> coaches) {
        RecommendMenu recommendMenu = new RecommendMenu(coaches);

        //카테고리 만들기
        createCategory(recommendMenu);

        //음식 추천
        recommendMenu.createCoachRecommendMenu();

        return recommendMenu;
    }

    private void createCategory(RecommendMenu recommendMenu) {
        int categoryNum = 0;
        while(categoryNum < 5) {
            if(recommendMenu.updateCategory(Category.getCategory(Randoms.pickNumberInRange(1, 5)))) {
                categoryNum++;
            }
        }
    }
}
