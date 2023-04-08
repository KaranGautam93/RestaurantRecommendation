package RestaurantRecommendation;

import Sort.SortType;

public class Driver {
    public static void main(String[] args) {
        RestaurantController restaurantController = new RestaurantController(1000);
        UserController userController = new UserController(5);
        User user = userController.getRandomUser();
        System.out.println("User Details " + user);
        System.out.println("Order 1 - Featured Primary cuisine and cost bracket if none then primary cuisine secondary cost bracket and vice-versa "
                + restaurantController.getRestaurantRecommendations(user, SortType.PRIMARY_CUISINE_PRIMARY_COST_BRACKET));
        System.out.println("Order 2 - Primary Cuisine Primary cost bracket with rating greater than equal to 4 "
                + restaurantController.getRestaurantRecommendations(user, SortType.PRIMARY_CUISINE_PRIMARY_COST_BRACKET_RATING_GREATER_EQUAL_4));
        System.out.println("Order 3 - Primary Cuisine secondary cost bracket with rating greater than equal to 4.5 "
                + restaurantController.getRestaurantRecommendations(user, SortType.PRIMARY_CUISINE_SECONDARY_COST_BRACKET_RATING_GREATER_EQUAL_4_5));
        System.out.println("Order 4 - Secondary Cuisine primary cost bracket with rating greater than equal to 4.5 "
                + restaurantController.getRestaurantRecommendations(user, SortType.SECONDARY_CUISINE_PRIMARY_COST_BRACKET_RATING_GREATER_EQUAL_4_5));
        System.out.println("Order 5 - Top 4 newly created restaurants by rating "
                + restaurantController.getRestaurantRecommendations(user, SortType.TOP_4_NEW_RESTAURANT_BY_RATING));
        System.out.println("Order 6 - Primary cuisine primary cost bracket with rating less than 4 "
                + restaurantController.getRestaurantRecommendations(user, SortType.PRIMARY_CUISINE_PRIMARY_COST_RATING_LESS_4));
        System.out.println("Order 7 - Primary cuisine secondary cost bracket with rating less than 4.5 "
                + restaurantController.getRestaurantRecommendations(user, SortType.PRIMARY_CUISINE_SECONDARY_COST_RATING_LESS_4_5));
        System.out.println("Order 8 - Secondary cuisine primary cost bracket with rating less than 4.5 "
                + restaurantController.getRestaurantRecommendations(user, SortType.SECONDARY_CUISINE_PRIMARY_COST_RATING_LESS_4_5));
        System.out.println("Order 9 - All restaurants of any cuisine any cost bracket "
                + restaurantController.getRestaurantRecommendations(user, SortType.ALL_RESTAURANT_ANY_CUISINE_COST_BRACKET));
    }
}
