// TestLogin.java
package com.bank.system;

public class TestLogin {
    public static void main(String[] args) {
        LoginService loginService = new LoginService();

        // Register a new user
        loginService.registerUser("john_doe", "password123");

        // Authenticate user
        String username = "john_doe";
        String password = "password123";

        if (loginService.authenticateUser(username, password)) {
            System.out.println("Login successful for user: " + username);
        } else {
            System.out.println("Invalid credentials for user: " + username);
        }
    }
}
