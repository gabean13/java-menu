package menu.model;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import menu.message.CommonMessage;
import menu.message.GuideMessage;

public class RecommendMenu {
    private List<Category> categories;
    private Map<Coach, List<String>> coachMenu;

    public RecommendMenu(List<Coach> coaches) {
        categories = new ArrayList<>();
        coachMenu = new LinkedHashMap<>();
        for (Coach coach : coaches) {
            coachMenu.put(coach, new ArrayList<>());
        }
    }

    public boolean updateCategory(Category category) {
        int count = 0;
        for (Category savedCategory : categories) {
            if (category == savedCategory) {
                count++;
            }
        }
        if (count >= 2) {
            return false;
        }
        categories.add(category);
        return true;
    }

    public void createCoachRecommendMenu() {
        for (Category category : categories) {
            for (Coach coach : coachMenu.keySet()) {
                List<String> menus = coachMenu.get(coach);
                String newMenu = Category.randomMenu(category, coach.getInedibleMenu(), menus);
                menus.add(newMenu);
            }
        }
    }

    public String printMenu() {
        StringBuilder sb = new StringBuilder();
        for (Coach coach : coachMenu.keySet()) {
            List<String> menus = coachMenu.get(coach);
            sb.append(
                    MessageFormat.format(GuideMessage.RECOMMEND_COACH_FOOD, coach.getName(), menus.get(0), menus.get(1),
                            menus.get(2), menus.get(3), menus.get(4)));
            sb.append(CommonMessage.NEW_LINE);
        }

        return sb.toString();
    }

    public String printCategory() {
        return MessageFormat.format(GuideMessage.RECOMMEND_CATEGORY, categories.get(0), categories.get(1),
                categories.get(2), categories.get(3), categories.get(4));
    }
}
