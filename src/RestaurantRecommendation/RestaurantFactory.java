package RestaurantRecommendation;

import java.util.Date;
import java.util.Random;

public class RestaurantFactory {

    private static final float max_rating = 5.0f;

    public static Restaurant generateRestaurant(int id) {
        Random random = new Random();

        Date date = new Date(random.nextLong(System.currentTimeMillis() - 500000000, System.currentTimeMillis()));

        return new Restaurant(id,
                CuisineType.values()[random.nextInt(CuisineType.values().length)], random.nextInt(1, UserFactory.max_cost_bracket),
                Float.parseFloat(String.format("%.2f", random.nextFloat(max_rating))), random.nextBoolean(), date);
    }
}
