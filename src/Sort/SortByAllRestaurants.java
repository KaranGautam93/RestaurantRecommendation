package Sort;

import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.List;

public class SortByAllRestaurants extends Sort {
    private SortType sortType = SortType.ALL_RESTAURANT_ANY_CUISINE_COST_BRACKET;

    public SortByAllRestaurants(Sort nextOrder) {
        super(nextOrder);
    }

    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> availableRestaurants, SortType sortType) {
        return availableRestaurants;
    }
}
