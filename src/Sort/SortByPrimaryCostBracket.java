package Sort;

import RestaurantRecommendation.CuisineType;
import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.List;

public class SortByPrimaryCostBracket extends Sort {
    private SortType sortType = SortType.PRIMARY_CUISINE_PRIMARY_COST_BRACKET;


    public SortByPrimaryCostBracket(Sort nextOrder) {
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

        if (filteredSorted.size() == 0) {
            filteredSorted = availableRestaurants;


            CuisineType cuisineTypes[] = user.getSecondaryCuisines(topCuisine);
            int costBrackets[] = user.getSecondaryBracket(topBracket);

            //secondary cuisine primary cost bracket
            for (int i = 0; i < cuisineTypes.length; i++) {
                filteredSorted = this.filterByCuisine(filteredSorted, cuisineTypes[i]);
            }
            List<Restaurant> filteredSecondaryCuisine = this.filterByCostBracket(filteredSorted, topBracket);


            //secondary cost bracket primary cuisine
            filteredSorted = availableRestaurants;
            for (int i = 0; i < costBrackets.length; i++) {
                filteredSorted = this.filterByCostBracket(filteredSorted, costBrackets[i]);
            }
            filteredSorted = this.filterByCuisine(filteredSorted, topCuisine);

            filteredSorted = this.uniqueRestaurants(filteredSecondaryCuisine, filteredSorted);
        }

        filteredSorted = this.sortByFeaturedType(filteredSorted, true);

        return filteredSorted;
    }
}
