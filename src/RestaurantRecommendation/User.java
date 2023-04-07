package RestaurantRecommendation;

import java.util.Arrays;

public class User {
    private CuisineTracking[] cuisines;
    private CostTracking[] costBracket;

    public User(CuisineTracking[] cuisines, CostTracking[] costBracket) {

        this.cuisines = cuisines;
        this.costBracket = costBracket;
    }

    public CuisineTracking[] getCuisines() {
        return cuisines;
    }

    public CuisineType getTopCuisine() {
        CuisineType type = null;
        int maxOrder = -1;

        for (CuisineTracking cuisine : cuisines) {
            if (cuisine.getNoOfOrders() > maxOrder) {
                type = cuisine.getType();
                maxOrder = cuisine.getNoOfOrders();
            }
        }
        return type;
    }

    public CuisineType[] getSecondaryCuisines(CuisineType primaryCuisineType) {
        CuisineType[] secondary = new CuisineType[CuisineType.values().length - 1];
        int i = 0;
        for (CuisineTracking cuisine : cuisines) {
            if (cuisine.getType() != primaryCuisineType) {
                secondary[i++] = cuisine.getType();
            }
        }

        return secondary;
    }

    public int getTopCostBracket() {
        int maxOrder = -1;
        int type = 0;

        for (CostTracking cost : costBracket) {
            if (cost.getNoOfOrders() > maxOrder) {
                type = cost.getType();
                maxOrder = cost.getNoOfOrders();
            }
        }

        return type;
    }

    public int[] getSecondaryBracket(int primaryType) {
        int[] secondary = new int[CuisineType.values().length - 1];
        int i = 0;
        for (CostTracking cost : costBracket) {
            if (cost.getType() != primaryType) {
                secondary[i++] = cost.getType();
            }
        }

        return secondary;
    }

    public CostTracking[] getCostBracket() {
        return costBracket;
    }

    @Override
    public String toString() {
        return "RestaurantRecommendation.User{" +
                "cuisines=" + Arrays.toString(cuisines) +
                ", costBracket=" + Arrays.toString(costBracket) +
                '}';
    }
}
