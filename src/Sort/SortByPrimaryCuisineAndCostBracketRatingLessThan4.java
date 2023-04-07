package Sort;

import Comparison.RatingComparisonOperator;
import RestaurantRecommendation.CuisineType;
import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.List;

public class SortByPrimaryCuisineAndCostBracketRatingLessThan4 extends Sort {
    private SortType sortType = SortType.PRIMARY_CUISINE_PRIMARY_COST_RATING_LESS_4;

    public SortByPrimaryCuisineAndCostBracketRatingLessThan4(Sort nextOrder) {
        super(nextOrder);
    }

    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> availableRestaurants, SortType sortType) {
        if (this.sortType != sortType) {
            return this.next.sortRestaurants(user, availableRestaurants, sortType);
        }
        List<Restaurant> filteredSorted;

        CuisineType topCuisine = user.getTopCuisine();
        int topBracket = user.getTopCostBracket();
        filteredSorted = this.filterByCuisine(availableRestaurants, topCuisine);
        filteredSorted = this.filterByCostBracket(filteredSorted, topBracket);
        filteredSorted = this.filterByRating(filteredSorted, 4, RatingComparisonOperator.LessThan);

        return filteredSorted;
    }
}
