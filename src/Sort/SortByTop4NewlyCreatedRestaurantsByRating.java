package Sort;

import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.List;

public class SortByTop4NewlyCreatedRestaurantsByRating extends Sort {
    private SortType sortType = SortType.TOP_4_NEW_RESTAURANT_BY_RATING;

    public SortByTop4NewlyCreatedRestaurantsByRating(Sort nextOrder) {
        super(nextOrder);
    }

    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> availableRestaurants, SortType sortType) {
        if (this.sortType != sortType) {
            return this.next.sortRestaurants(user, availableRestaurants, sortType);
        }

        List<Restaurant> filtered = this.filterNewlyCreatedRestaurantsByCreatedHours(availableRestaurants, 48);
        filtered = this.selectTopNRatedRestaurants(filtered, 4);

        return filtered;
    }
}
