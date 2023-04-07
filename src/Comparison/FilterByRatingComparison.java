package Comparison;

import RestaurantRecommendation.Restaurant;

import java.util.List;

public interface FilterByRatingComparison {
    public List<Restaurant> filter(List<Restaurant> availableRestaurants, float value);
}
