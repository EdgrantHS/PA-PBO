package Model;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.sql.Timestamp;

/**
 * The {@code Book} class represents a book with information such as title, author, publisher,
 * publish time, available quantity, and availability status.
 * <p>
 * This class extends the {@link Model.Serializable} class to support serialization.
 * </p>
 *
 * @author Darmawan Hanif
 */
public class Book extends Serializable {

    /**
     * The unique identifier for the book, annotated with {@link BsonId}.
     */
    @BsonId
    public ObjectId _id;

    /**
     * The title of the book.
     */
    public String title;

    /**
     * The author of the book.
     */
    public String author;

    /**
     * The publisher of the book.
     */
    public String publisher;

    /**
     * The publish time of the book.
     */
    public String publishTime;

    /**
     * The total quantity of the book available.
     */
    private int amount;

    /**
     * The availability status of the book.
     */
    private boolean availability;

    /**
     * Constructs a new {@code Book} with the specified details.
     *
     * @param title       The title of the book.
     * @param author      The author of the book.
     * @param publisher   The publisher of the book.
     * @param publishTime The publish time of the book.
     * @param amount      The initial quantity of the book.
     */
    public Book(String title, String author, String publisher, String publishTime, int amount) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishTime = publishTime;
        this.amount = amount;
        if (amount > 0) this.availability = true;
    }

<<<<<<< HEAD
=======
    /**
     * Default constructor for the {@code Book} class.
     * <p>
     * Initializes the book with default values.
     * </p>
     */
>>>>>>> a7f57236a619a86d932837d17068fdf4d2ff02e5
    public Book() {
        super();
    }

    /**
     * Retrieves the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title for the book.
     *
     * @param title The new title to be set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the author of the book.
     *
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author for the book.
     *
     * @param author The new author to be set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Retrieves the publisher of the book.
     *
     * @return The publisher of the book.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher for the book.
     *
     * @param publisher The new publisher to be set.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Retrieves the publish time of the book.
     *
     * @return The publish time of the book.
     */
    public String getPublishTime() {
        return publishTime;
    }

    /**
     * Sets the publish time for the book.
     *
     * @param publishTime The new publish time to be set.
     */
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * Retrieves the total quantity of the book available.
     *
     * @return The quantity of the book available.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets the total quantity of the book available.
     *
     * @param amount The new quantity to be set.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Checks the availability status of the book.
     *
     * @return {@code true} if the book is available, {@code false} otherwise.
     */
    public boolean isAvailability() {
        return availability;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param availability The new availability status to be set.
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * Increases the quantity of the book by 1 and updates the availability status.
     */
    public void addThisBook() {
        this.amount++;
        if (amount > 0) this.availability = true;
    }

    /**
     * Reduces the quantity of the book by 1 and updates the availability status.
     * If the quantity becomes zero, the availability status is set to false.
     */
    public void reduceThisBook() {
        this.amount--;
        if (this.amount <= 0) {
            this.amount = 0;
            this.availability = false;
        }
    }
}
