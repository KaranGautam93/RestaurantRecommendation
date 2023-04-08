package RestaurantRecommendation;

import Sort.SortType;

public class Driver {
    public static void main(String[] args) {
        RestaurantController restaurantController = new RestaurantController(1000);
        UserController userController = new UserController(5);
        User user = userController.getRandomUser();
        System.out.println(restaurantController.getRestaurantRecommendations(user, SortType.SECONDARY_CUISINE_PRIMARY_COST_RATING_LESS_4_5));
    }
}
