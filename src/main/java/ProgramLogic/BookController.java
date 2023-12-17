package ProgramLogic;

import GUI.MainPage;
import Model.Book;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import db.MongoDB;

/**
 * The {@code BookController} class is responsible for handling interactions and
 * updates related to the MongoDB collection of books. It includes methods for
 * observing changes in the collection and updating the application's book list.
 * @author Darmawan Hanif
 */

public class BookController {

    /**
     * The MongoDB collection representing books.
     */
    public static MongoCollection<Book> collection = MongoDB.getDatabaseInstance().getCollection("Books", Book.class);

    /**
     * Listens for changes in the MongoDB collection of books and updates the
     * application's book list accordingly.
     */
    public static void booksObserver() {
        try (MongoCursor<ChangeStreamDocument<Book>> changes = BookController.collection.watch().iterator()) {
            // Synchronously listen for changes
            while (changes.hasNext()) {
                ChangeStreamDocument<Book> change = changes.next();
                // Handle the change synchronously
                Book updatedBook = change.getFullDocument();
                if (MainPage.books.contains(updatedBook)) {
                    int index = MainPage.books.indexOf(updatedBook);
                    MainPage.books.set(index, updatedBook);
                } else {
                    MainPage.books.add(updatedBook);
                }
            }
        }
    }
}
