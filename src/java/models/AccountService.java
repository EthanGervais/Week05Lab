package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ethan Gervais
 */
public class AccountService implements Serializable {

    private ArrayList<User> authorizedUsers;

    public AccountService() {
        authorizedUsers = new ArrayList<>();
        User abe = new User("abe", "password");
        User barb = new User("barb", "password");

        authorizedUsers.add(abe);
        authorizedUsers.add(barb);
    }

    public User login(String username, String password) {
        User authUser = null;

        for (User user : authorizedUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authUser = new User(username, null);
            }
        }

        return authUser;
    }

}
