package Model;

import org.bson.codecs.pojo.annotations.BsonId;

import java.sql.Timestamp;

public class Book extends Serializable implements AutoCloseable {
    @BsonId
    public String title;
    public String author;
    public String publisher;
    public Timestamp publishTime;
    private int amount;
    private boolean availability;

    public Book() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void addThisBook() {
        this.amount++;
        if (amount > 0) this.availability = true;
    }

    public void reduceThisBook() {
        this.amount--;
        if (this.amount <= 0) {
            this.amount = 0;
            this.availability = false;
        }
    }

    @Override
    public void close() throws Exception {
        return;
    }
}
