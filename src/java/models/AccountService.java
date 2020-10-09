package models;

import java.io.Serializable;

/**
 *
 * @author Ethan Gervais
 */
public class AccountService implements Serializable {

    public AccountService() {

    }

    public boolean login(String username, String password) {
        if (username == null || username.equals("") || password == null || password.equals("")) {
            return false;
        }
        
        if (username.toLowerCase().equals("abe") || username.toLowerCase().equals("barb") || password.equals("password")){
            return true;
        }

        return false;
    }

}
