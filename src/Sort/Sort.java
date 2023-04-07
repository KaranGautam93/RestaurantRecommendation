package Sort;

import Comparison.*;
import RestaurantRecommendation.CuisineType;
import RestaurantRecommendation.Restaurant;
import RestaurantRecommendation.User;

import java.util.*;

public abstract class Sort {
    protected Sort next;
    protected SortType sortType;

    public Sort(Sort nextOrder) {
        this.next = nextOrder;
    }

    public abstract List<Restaurant> sortRestaurants(User user, List<Restaurant> availableRestaurants, SortType sortType);

    protected List<Restaurant> filterByCuisine(List<Restaurant> availableRestaurants, CuisineType cuisineType) {
        List<Restaurant> filtered = new ArrayList<>();

        for (Restaurant restaurant : availableRestaurants) {
            if (restaurant.getCuisine() == cuisineType) {
                filtered.add(restaurant);
            }
        }

        return filtered;
    }

    protected List<Restaurant> filterByCostBracket(List<Restaurant> availableRestaurants, int costBracket) {
        List<Restaurant> filtered = new ArrayList<>();

        for (Restaurant restaurant : availableRestaurants) {
            if (restaurant.getCostBracket() == costBracket) {
                filtered.add(restaurant);
            }
        }

        return filtered;
    }

    protected List<Restaurant> filterByRating(List<Restaurant> availableRestaurants, float rating, RatingComparisonOperator operator) {
        FilterByRatingComparison filterByRatingComparison = null;
        switch (operator) {
            case LessThan -> filterByRatingComparison = new LessThan();
            case GreaterThan -> filterByRatingComparison = new GreaterThan();
            case GreaterThanEqualTo -> filterByRatingComparison = new GreaterThanEqual();
            case LessThanEqualTo -> filterByRatingComparison = new LessThanEqualTo();
        }

        return filterByRatingComparison.filter(availableRestaurants, rating);
    }

    protected List<Restaurant> sortByFeaturedType(List<Restaurant> availableRestaurants, Boolean isRecommended) {
        List<Restaurant> filtered = new ArrayList<>();

        for (Restaurant restaurant : availableRestaurants) {
            if (restaurant.isRecommended() == isRecommended) {
                filtered.add(restaurant);
            }
        }

        return filtered;
    }

    protected List<Restaurant> uniqueRestaurants(List<Restaurant> list1, List<Restaurant> list2) {
        List<Restaurant> filtered = new ArrayList<>();

        Map<Integer, Restaurant> foundMap = new HashMap<Integer, Restaurant>();

        for (Restaurant restaurant : list1) {
            foundMap.put(restaurant.getRestaurantId(), restaurant);
            filtered.add(restaurant);
        }

        for (Restaurant restaurant : list2) {
            if (foundMap.getOrDefault(restaurant.getRestaurantId(), null) == null) {
                filtered.add(restaurant);
            }
        }

        return filtered;
    }

    public List<Restaurant> selectTopNRatedRestaurants(List<Restaurant> availableRestaurants, int n) {

        Collections.sort(availableRestaurants, (Object r1, Object r2) -> {
            if (((Restaurant) r1).getRating() < (((Restaurant) r2).getRating())) {
                return 1;
            } else if (((Restaurant) r1).getRating() > (((Restaurant) r2).getRating())) {
                return -1;
            } else {
                return 0;
            }
        });

        List<Restaurant> filtered = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            filtered.add(availableRestaurants.get(i));
        }

        return filtered;
    }

    public List<Restaurant> filterNewlyCreatedRestaurantsByCreatedHours(List<Restaurant> availableRestaurants, int hours) {
        List<Restaurant> filtered = new ArrayList<>();

        Date date = new Date();

        for (Restaurant restaurant : availableRestaurants) {
            if (((date.getTime() - restaurant.getOnboardedTime().getTime()) / (1000 * 60 * 60)) <= hours) {
                filtered.add(restaurant);
            }
        }

        return filtered;
    }
}
