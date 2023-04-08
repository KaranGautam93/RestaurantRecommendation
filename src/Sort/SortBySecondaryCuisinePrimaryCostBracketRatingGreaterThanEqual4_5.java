package Sort;

import Comparison.RatingComparisonOperator;
import RestaurantRecommendation.CuisineType;
import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.ArrayList;
import java.util.List;

public class SortBySecondaryCuisinePrimaryCostBracketRatingGreaterThanEqual4_5 extends Sort {
    private SortType sortType = SortType.SECONDARY_CUISINE_PRIMARY_COST_BRACKET_RATING_GREATER_EQUAL_4_5;

    public SortBySecondaryCuisinePrimaryCostBracketRatingGreaterThanEqual4_5(Sort nextOrder) {
        super(nextOrder);
    }

    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> availableRestaurants, SortType sortType) {
        if (this.sortType != sortType) {
            return this.next.sortRestaurants(user, availableRestaurants, sortType);
        }


        CuisineType cuisineType = user.getTopCuisine();
        int primaryCostBracket = user.getTopCostBracket();
        CuisineType secondaryCuisines[] = user.getSecondaryCuisines(cuisineType);

        List<Restaurant> filteredSorted = this.filterByRating(availableRestaurants, 4.5f, RatingComparisonOperator.GreaterThanEqualTo);
        filteredSorted = this.filterByCostBracket(filteredSorted, primaryCostBracket);

        List<Restaurant> secondary = new ArrayList<>();

        for (int i = 0; i < secondaryCuisines.length; i++) {
            secondary.addAll(this.filterByCuisine(filteredSorted, secondaryCuisines[i]));
        }

        return this.getNRestaurants(secondary, n_restaurants);
    }
}
