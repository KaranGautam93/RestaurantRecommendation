package RestaurantRecommendation;

public class CuisineTracking {
    private CuisineType type;
    private int noOfOrders;

    public CuisineTracking(CuisineType type, int noOfOrders) {
        this.type = type;
        this.noOfOrders = noOfOrders;
    }

    public CuisineType getType() {
        return type;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    @Override
    public String toString() {
        return "RestaurantRecommendation.CuisineTracking{" +
                "type=" + type +
                ", noOfOrders=" + noOfOrders +
                '}';
    }
}
