package RestaurantRecommendation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserController {
    private List<User> users;
    private int noOfUsers;

    public UserController(int noOfUsers) {
        this.noOfUsers = noOfUsers;
        users = new ArrayList<>(this.noOfUsers);
        createUsers();
    }

    private void createUsers() {
        for (int i = 0; i < noOfUsers; i++) {
            users.add(UserFactory.generate());
        }
    }

    public User getRandomUser() {
        Random random = new Random();
        return users.get(random.nextInt(0, users.size() - 1));
    }

    @Override
    public String toString() {
        String str = "RestaurantRecommendation.UserController{\n";
        for (User user : users) {
            str += "\n" + user.toString();
        }

        return str;
    }
}
