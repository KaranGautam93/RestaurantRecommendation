package Sort;

import Comparison.RatingComparisonOperator;
import RestaurantRecommendation.CuisineType;
import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.List;

public class SortBySecondaryCuisinePrimaryCostBracketRatingLessThan4_5 extends Sort {
    private SortType sortType = SortType.SECONDARY_CUISINE_PRIMARY_COST_RATING_LESS_4_5;

    public SortBySecondaryCuisinePrimaryCostBracketRatingLessThan4_5(Sort nextOrder) {
        super(nextOrder);
    }

    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> availableRestaurants, SortType sortType) {
        if (this.sortType != sortType) {
            return this.next.sortRestaurants(user, availableRestaurants, sortType);
        }
        List<Restaurant> filteredSorted;

        CuisineType topCuisine = user.getTopCuisine();
        CuisineType secondaryCuisines[] = user.getSecondaryCuisines(topCuisine);

        int topBracket = user.getTopCostBracket();

        filteredSorted = this.filterByCostBracket(availableRestaurants, topBracket);

        for (int i = 0; i < secondaryCuisines.length; i++) {
            filteredSorted = this.filterByCuisine(filteredSorted, secondaryCuisines[i]);
        }

        filteredSorted = this.filterByRating(filteredSorted, 4.5f, RatingComparisonOperator.LessThan);

        return filteredSorted;
    }
}
