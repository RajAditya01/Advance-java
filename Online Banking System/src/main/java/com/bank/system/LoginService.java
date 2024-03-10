// LoginService.java
package com.bank.system;

import java.util.HashMap;

public class LoginService {
    private HashMap<String, User> usersDatabase;

    public LoginService() {
        this.usersDatabase = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        User newUser = new User(username, password);
        usersDatabase.put(username, newUser);
    }

    public boolean authenticateUser(String username, String password) {
        User user = usersDatabase.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
