package RestaurantRecommendation;

import Sort.*;

import java.util.ArrayList;
import java.util.List;

public class RestaurantController {
    private int numberOfRestaurants;
    private List<Restaurant> restaurants;

    RestaurantController(int numberOfRestaurants) {
        this.numberOfRestaurants = numberOfRestaurants;
        restaurants = new ArrayList<>(this.numberOfRestaurants);
        createRestaurants();
    }


    public void createRestaurants() {
        for (int i = 0; i < numberOfRestaurants; i++) {
            restaurants.add(RestaurantFactory.generateRestaurant(i));
        }
    }

    public String getRestaurantRecommendations(User user, SortType sortType) {
        Sort sort = new SortByPrimaryCostBracket(
                new SortByPrimaryCuisinePrimaryCostBracketRatingGreaterThanEqualTo4(
                        new SortByPrimaryCuisineSecondaryCostRatingGreaterThanEqual4_5(
                                new SortBySecondaryCuisinePrimaryCostBracketRatingGreaterThanEqual4_5(
                                        new SortByTop4NewlyCreatedRestaurantsByRating(
                                                new SortByPrimaryCuisineAndCostBracketRatingLessThan4(
                                                        new SortByPrimaryCuisineSecondaryCostBracketRatingLessThan4_5(
                                                                new SortBySecondaryCuisinePrimaryCostBracketRatingLessThan4_5(
                                                                        new SortByAllRestaurants(null)
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ));
        return sort.sortRestaurants(user, restaurants, sortType).toString();
    }

    @Override
    public String toString() {
        String str = "RestaurantRecommendation.RestaurantController{" +
                "numberOfRestaurants=" + numberOfRestaurants +
                ", restaurants=";

        for (Restaurant restaurant : restaurants) {
            str += "\n" + restaurant.getRestaurantId() + " " + restaurant.getCostBracket() + " " + restaurant.getCuisine() +
                    " " + restaurant.getRating() + " " + restaurant.getOnboardedTime().toString();
        }
        return str;
    }
}
