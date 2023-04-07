package RestaurantRecommendation;

import Sort.SortType;

public class Driver {
    public static void main(String[] args) {
        RestaurantController restaurantController = new RestaurantController(10);
        UserController userController = new UserController(5);
        User user = userController.getRandomUser();
        System.out.println(restaurantController.getRestaurantRecommendations(user, SortType.ALL_RESTAURANT_ANY_CUISINE_COST_BRACKET));
    }
}
