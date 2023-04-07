package Sort;

import Comparison.RatingComparisonOperator;
import RestaurantRecommendation.CuisineType;
import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.List;

public class SortByPrimaryCuisinePrimaryCostBracketRatingGreaterThanEqualTo4 extends Sort {
    private SortType sortType = SortType.PRIMARY_CUISINE_PRIMARY_COST_BRACKET_RATING_GREATER_EQUAL_4;

    public SortByPrimaryCuisinePrimaryCostBracketRatingGreaterThanEqualTo4(Sort nextOrder) {
        super(nextOrder);
    }


    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> availableRestaurants, SortType sortType) {
        if (this.sortType != sortType) {
            return this.next.sortRestaurants(user, availableRestaurants, sortType);
        }


        CuisineType cuisineType = user.getTopCuisine();
        int costBracket = user.getTopCostBracket();
        List<Restaurant> filteredSorted = this.filterByRating(availableRestaurants, 4, RatingComparisonOperator.GreaterThanEqualTo);
        filteredSorted = this.filterByCuisine(filteredSorted, cuisineType);
        filteredSorted = this.filterByCostBracket(filteredSorted, costBracket);

        return filteredSorted;
    }
}
