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

public class AccountController {
    public static MongoCollection<Account> collection = MongoDB.getDatabaseInstance().getCollection("Account", Account.class);
    private static Account loggedInAccount;

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

    public static Account getAccountDetails() {
        // Retrieve account details based on the username
        return loggedInAccount;
    }

    public static boolean register(String username, String name, String email, String password) {
        boolean exist = collection.find(Filters.and(
                Filters.eq("username", username),
                Filters.eq("email", email),
                Filters.eq("password",password)
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
