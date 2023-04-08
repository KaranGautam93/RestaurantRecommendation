package RestaurantRecommendation;

import java.util.Random;

public class UserFactory {

    public static final int max_cost_bracket = 5;
    private static final int max_orders = 100;

    public static User generate() {
        Random random = new Random();
        CuisineType cuisineType[] = CuisineType.values();
        CuisineTracking cuisines[] = new CuisineTracking[cuisineType.length];
        CostTracking costs[] = new CostTracking[cuisineType.length];

        for (int i = 0; i < cuisineType.length; i++) {
            int orders = random.nextInt(max_orders);
            cuisines[i] = new CuisineTracking(cuisineType[i], orders);
            costs[i] = new CostTracking(random.nextInt(1, max_cost_bracket), orders);
        }
        return new User(cuisines, costs);
    }
}
