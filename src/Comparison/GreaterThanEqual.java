package Comparison;

import RestaurantRecommendation.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class GreaterThanEqual implements FilterByRatingComparison {
    @Override
    public List<Restaurant> filter(List<Restaurant> availableRestaurants, float value) {
        List<Restaurant> filtered = new ArrayList<>();

        for (Restaurant restaurant : availableRestaurants) {
            if (restaurant.getRating() >= value) {
                filtered.add(restaurant);
            }
        }

        return filtered;
    }
}
