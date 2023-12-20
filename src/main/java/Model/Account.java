package Model;


import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * The {@code Account} class represents a user account with basic information such as
 * username, name, email, password, and rating.
 * <p>
 * This class extends the {@link Model.Serializable} class to support serialization.
 * </p>
 *
 * @author Darmawan Hanif
 */

public class Account extends Serializable {

    /**
     * The unique identifier for the account, annotated with {@link BsonId}.
     */
    @BsonId
    public ObjectId _id;

    /**
     * The username associated with the account.
     */
    private String username;

    /**
     * The name of the account holder.
     */
    private String name;

    /**
     * The email address associated with the account.
     */
    private String email;

    /**
     * The password associated with the account.
     */
    private String password;

    /**
     * The rating of the account.
     */
    public int rating;

    /**
     * Default constructor for the {@code Account} class.
     * <p>
     * Initializes the account with default values.
     * </p>
     */
    public Account() {
        super();
    }

    /**
     * Retrieves the username associated with the account.
     *
     * @return The username of the account.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the account.
     *
     * @param username The new username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the name of the account holder.
     *
     * @return The name of the account holder.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the account holder.
     *
     * @param name The new name to be set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the email address associated with the account.
     *
     * @return The email address of the account.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address for the account.
     *
     * @param email The new email address to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the password associated with the account.
     *
     * @return The password of the account.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the account.
     *
     * @param password The new password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
