package ProgramLogic;

import Model.Account;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import db.MongoDB;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The AccountController class manages the logic for user authentication,
 * registration, and retrieval of account details in the context of a library
 * management system. It interacts with the MongoDB database to store and
 * retrieve account information.
 *
 * <p>It includes methods for authenticating users, registering new accounts,
 * and retrieving account details. It also maintains a collection of user
 * accounts in memory for quick access and tracks the currently logged-in account.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 *     // Authenticate a user
 *     boolean isAuthenticated = AccountController.authenticate("username", "password");
 *
 *     // Register a new account
 *     boolean isRegistered = AccountController.register("newUsername", "Name", "email@example.com", "password");
 *
 *     // Get details of the logged-in account
 *     Account loggedInAccount = AccountController.getAccountDetails();
 * </pre>
 *
 * <p>Note: The MongoDB connection details and collection name are assumed
 * to be configured properly in the MongoDB class.</p>
 *
 * @author Phoebe Ivana
 * @version 1.0
 */
public class AccountController {
    /**
     * The MongoDB collection for storing Account objects.
     */
    public static MongoCollection<Account> collection = MongoDB.getDatabaseInstance().getCollection("Account", Account.class);
    /**
     * A map to store Account objects in memory for quick access.
     */
    public static Map<String, Account> dataBaseAcc = new HashMap<>();
    /**
     * The currently logged-in account.
     */
    public static Account loggedInAccount;

    /**
     * Authenticates a user based on the provided username and password.
     *
     * @param username The username of the account.
     * @param password The password of the account.
     * @return True if authentication is successful, false otherwise.
     * @author Phoebe Ivana
     */
    public static boolean authenticate(String username, String password) {
        Account exist = collection.find(Filters.and(
                Filters.eq("username", username),
                Filters.eq("password", password)
        )).first();

        if (exist != null) {
            System.out.println("Account found: " + exist);
            loggedInAccount = exist;
            return true;
        } else {
            System.out.println("Account not found");
            return false;
        }
    }

    /**
     * Retrieves details of the currently logged-in account.
     *
     * @return The Account object representing the logged-in account.
     * @author Darren
     */
    public static Account getAccountDetails() {
        // Retrieve account details based on the username
        return loggedInAccount;
    }

    /**
     * Registers a new account with the specified username, name, email, and password.
     *
     * @param username The desired username for the new account.
     * @return True if registration is successful, false otherwise (e.g., username already taken).
     * @author Phoebe Ivana
     */
    public static Account getAccountByUsername(String username) {
        // Retrieve account details based on the username
        return collection.find(Filters.eq("username", username)).first();
    }

    public static boolean register(String username, String name, String email, String password) {
        boolean exist = collection.find(Filters.and(
                Filters.eq("username", username),
                Filters.eq("email", email),
                Filters.eq("password", password)

        )).first() != null;
        // Check if the username already exists
        if (exist) {
            return false; // Username already taken
        }

        // Register the new user
        Account a = new Account();
        a._id = new ObjectId();
        a.setUsername(username);
        a.setEmail(email);
        a.setPassword(password);
        a.setName(name);

        if (collection.insertOne(a).wasAcknowledged()) {
            System.out.println("New Account added: " + a);
        } else {
            System.out.println("Insertion failed");
        }

        return true; // Registration successful
    }
}
