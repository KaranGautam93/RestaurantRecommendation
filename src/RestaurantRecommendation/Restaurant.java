package RestaurantRecommendation;

import java.util.Date;

public class Restaurant {
    private int restaurantId;
    private CuisineType cuisine;
    private int costBracket;
    private float rating;
    private boolean isRecommended;
    private Date onboardedTime;

    public Restaurant(int restaurantId, CuisineType cuisine, int costBracket, float rating, boolean isRecommended, Date onboardedTime) {
        this.restaurantId = restaurantId;

        this.cuisine = cuisine;
        this.costBracket = costBracket;
        this.rating = rating;
        this.isRecommended = isRecommended;
        this.onboardedTime = onboardedTime;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public CuisineType getCuisine() {
        return cuisine;
    }

    public int getCostBracket() {
        return costBracket;
    }

    public float getRating() {
        return rating;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public Date getOnboardedTime() {
        return onboardedTime;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", cuisine=" + cuisine +
                ", costBracket=" + costBracket +
                ", rating=" + rating +
                ", isRecommended=" + isRecommended +
                ", onboardedTime=" + onboardedTime +
                '}';
    }
}
