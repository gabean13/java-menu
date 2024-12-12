package menu.view;

import menu.message.GuideMessage;
import menu.model.RecommendMenu;

public class OutputView {
    public void printMenu(RecommendMenu recommendMenu) {
        System.out.println(GuideMessage.RECOMMEND_START);
        System.out.println(GuideMessage.RECOMMEND_DATE);
        System.out.println(recommendMenu.printCategory());
        System.out.println(recommendMenu.printMenu());
        System.out.println(GuideMessage.RECOMMEND_END);
    }
}
