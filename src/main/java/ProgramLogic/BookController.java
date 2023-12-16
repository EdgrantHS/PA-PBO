package ProgramLogic;

import Model.Book;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import db.MongoDB;
import org.bson.types.ObjectId;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookController {
    public static MongoCollection<Book> collection = MongoDB.getDatabaseInstance().getCollection("Book", Book.class);

    // dummy list book, call only for once
    public static void generateBook() {
        List<Book> bookList = new ArrayList<>();

        // Manually create instances with real book titles, authors, and publish times
        Book book1 = new Book();
        book1._id = new ObjectId();
        book1.id = 125258766;
        book1.title = "The Catcher in the Rye";
        book1.author = "J.D. Salinger";
        book1.publisher = "Little, Brown and Company";
        book1.publishTime = "1951-07-16";
        book1.setAmount(40);

        Book book2 = new Book();
        book2._id = new ObjectId();
        book2.id = 125258566;
        book2.title = "To Kill a Mockingbird";
        book2.author = "Harper Lee";
        book2.publisher = "J.B. Lippincott & Co.";
        book2.publishTime = "1960-07-11";
        book2.setAmount(30);

        Book book3 = new Book();
        book3._id = new ObjectId();
        book3.id = 125258766;
        book3.title = "The Great Gatsby";
        book3.author = "F. Scott Fitzgerald";
        book3.publisher = "Charles Scribner's Sons";
        book3.publishTime = "1925-04-10";
        book3.setAmount(25);

        // Continue adding more books...

        // Add books to the list
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        collection.insertMany(bookList);
    }

    public static List<Book> getListBook() {
        List<Book> bookList = new ArrayList<>();

        FindIterable<Book> result = collection.find();

        result.forEach(b-> {
            System.out.println(b);

            Book book = new Book();
            book.title = b.getTitle();
            book.author = b.getAuthor();
            book.publisher = b.getPublisher();
            book.publishTime = b.getPublishTime();
            book.setAmount(b.getAmount());
            book.setAvailability(b.isAvailability());

            bookList.add(book);
        });
        return bookList;
    }

    public static String formatTimestamp(Timestamp timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date(timestamp.getTime()));
    }

    private static Timestamp parsePublishTime(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(dateString);
            return new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
