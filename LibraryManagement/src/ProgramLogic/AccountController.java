package ProgramLogic;

import Model.Account;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AccountController {
    public static Map<String, Account> dataBaseAcc = new HashMap<>();
    private static String loggedInUsername;

    public static boolean authenticate(String username, String password) {
        // Check if the provided credentials match any stored user credentials
        if (dataBaseAcc.containsKey(username) && dataBaseAcc.get(username).getPassword().equals(password)){
            loggedInUsername = username;
            return true;
        }
        return false;
    }

    public static Account getAccountDetails() {
        // Retrieve account details based on the username
        return dataBaseAcc.get(loggedInUsername);
    }

    public static boolean register(String username, String name, String email, String password) {
        // Check if the username already exists
        if (dataBaseAcc.containsKey(username)) {
            return false; // Username already taken
        }

        // Register the new user
        dataBaseAcc.put(username, new Account(username, name, email, password));
        return true; // Registration successful
    }
}
