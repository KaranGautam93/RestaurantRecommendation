package Sort;

import Comparison.RatingComparisonOperator;
import RestaurantRecommendation.CuisineType;
import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.List;

public class SortByPrimaryCuisineSecondaryCostRatingGreaterThanEqual4_5 extends Sort {
    private SortType sortType = SortType.PRIMARY_CUISINE_SECONDARY_COST_BRACKET_RATING_GREATER_EQUAL_4_5;

    public SortByPrimaryCuisineSecondaryCostRatingGreaterThanEqual4_5(Sort nextOrder) {
        super(nextOrder);
    }

    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> availableRestaurants, SortType sortType) {
        if (this.sortType != sortType) {
            return this.next.sortRestaurants(user, availableRestaurants, sortType);
        }


        CuisineType cuisineType = user.getTopCuisine();
        int primaryCostBracket = user.getTopCostBracket();
        int costBracket[] = user.getSecondaryBracket(primaryCostBracket);

        List<Restaurant> filteredSorted = this.filterByRating(availableRestaurants, 4.5f, RatingComparisonOperator.GreaterThanEqualTo);
        filteredSorted = this.filterByCuisine(filteredSorted, cuisineType);

        for (int i = 0; i < costBracket.length; i++) {
            filteredSorted = this.filterByCostBracket(filteredSorted, costBracket[i]);
        }

        return this.getNRestaurants(filteredSorted, n_restaurants);
    }
}
