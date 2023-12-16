package Model;

import java.sql.Timestamp;

public class Book extends Serializable {
    public String title;
    public String author;
    public String publisher;
    public Timestamp publishTime;
    private int amount;
    private boolean availability;

    public Book(int isbn, String title, String author, String publisher, Timestamp publishTime, int amount) {
        this.id = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishTime = publishTime;
        if (amount <= 0) {
            this.amount = 0;
            this.availability = false;
        }
        else {
            this.amount = amount;
            this.availability = true;
        }
    }

    public boolean getAvailability() {
        return this.availability;
    }

    public int getAmount() {
        return this.amount;
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
}
