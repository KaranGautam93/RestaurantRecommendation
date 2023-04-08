package Sort;

import Comparison.RatingComparisonOperator;
import RestaurantRecommendation.CuisineType;
import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.ArrayList;
import java.util.List;

public class SortByPrimaryCuisineSecondaryCostBracketRatingLessThan4_5 extends Sort {
    private SortType sortType = SortType.PRIMARY_CUISINE_SECONDARY_COST_RATING_LESS_4_5;

    public SortByPrimaryCuisineSecondaryCostBracketRatingLessThan4_5(Sort nextOrder) {
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
        int secondaryCostBrackets[] = user.getSecondaryBracket(topBracket);

        filteredSorted = this.filterByCuisine(availableRestaurants, topCuisine);

        List<Restaurant> secondaryList = new ArrayList<>();

        for (int i = 0; i < secondaryCostBrackets.length; i++) {
            secondaryList.addAll(this.filterByCostBracket(filteredSorted, secondaryCostBrackets[i]));
        }

        filteredSorted = this.filterByRating(secondaryList, 4.5f, RatingComparisonOperator.LessThan);

        return this.getNRestaurants(filteredSorted, n_restaurants);
    }
}
