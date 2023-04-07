package RestaurantRecommendation;

public class CostTracking {
    private int type;
    private int noOfOrders;

    public CostTracking(int type, int noOfOrders) {
        this.type = type;
        this.noOfOrders = noOfOrders;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RestaurantRecommendation.CostTracking{" +
                "type=" + type +
                ", noOfOrders=" + noOfOrders +
                '}';
    }
}
