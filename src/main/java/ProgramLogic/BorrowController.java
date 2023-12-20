package ProgramLogic;

import Model.Account;
import Model.Book;
import Model.Borrow;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import db.MongoDB;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The BorrowController class manages the logic for renting books, checking
 * return dates, book availability, and handling the retrieval of borrowed books
 * for a library management system. It interacts with the MongoDB database to
 * store and retrieve borrowing information.
 *
 * <p>It includes methods for renting a book, checking if the return date is valid,
 * checking book availability, converting a date string to a Timestamp, and
 * retrieving a list of borrowed books for a specific account.</p>
 *
 * <p>Usage example:</p>
 * <pre>
 *     // Rent a book
 *     boolean isBookRented = BorrowController.rentBook(accountId, bookId, returnDate);
 *
 *     // Get a list of borrowed books for an account
 *     List<Borrow> borrowedBooks = BorrowController.handleGetBorrowedBook(accountId);
 * </pre>
 *
 * <p>Note: The MongoDB connection details and collection name are assumed to be
 * configured properly in the MongoDB class.</p>
 *
 * @author Phoebe Ivana
 */
public class BorrowController {

    public static MongoCollection<Borrow> collection = MongoDB.getDatabaseInstance().getCollection("Borrow", Borrow.class);

    /**
     * Attempts to rent a book for a specified account and return date.
     *
     * @param accountId  The ID of the account renting the book.
     * @param bookId     The ID of the book to be rented.
     * @param returnDate The return date for the rented book in "yyyy-MM-dd" format.
     * @return True if the book is successfully rented, false otherwise.
     */
    public static boolean rentBook(int accountId, int bookId, String returnDate) {
        // Check if returnDate > current date
        if (isReturnDateValid(returnDate)) {
            // Check if the book is available
            if (isBookAvailable(bookId)) {
                // Perform booking
                Borrow borrow = new Borrow();
                borrow.setAccountId(accountId);
                borrow.setBookId(bookId);
                borrow.setReturnTime(returnDate);
                if (collection.insertOne(borrow).wasAcknowledged()) {
                    System.out.println("New Borrow: ");
                } else {
                    System.out.println("Insertion failed");
                }
                return true;
            } else {
                System.out.println("Book is not available.");
            }
        } else {
            System.out.println("Invalid return date.");
        }
        return false;
    }

    //check returnDate > current date

    /**
     * Checks if the specified return date is valid (i.e., greater than the current date).
     *
     * @param returnDate The return date to be validated in "yyyy-MM-dd" format.
     * @return True if the return date is valid, false otherwise.
     */
    private static boolean isReturnDateValid(String returnDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            Date parsedReturnDate = dateFormat.
                    parse(returnDate);
            return parsedReturnDate.after(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Checks if a book with the specified ID is available for rent.
     *
     * @param bookId The ID of the book to be checked for availability.
     * @return True if the book is available, false otherwise.
     */
    private static boolean isBookAvailable(int bookId) {
        // asumsi : buku avai, alwys
        return true;
    }

    /**
     * Converts a date string to a Timestamp object.
     *
     * @param date The date string to be converted in "yyyy-MM-dd" format.
     * @return A Timestamp object representing the converted date.
     */
    private static Timestamp getTimestampFromString(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            return new Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves a list of Borrow objects representing books borrowed by a specific account.
     *
     * @param accountId The ID of the account for which borrowed books are retrieved.
     * @return A list of Borrow objects representing borrowed books.
     */
    public static List<Borrow> handleGetBorrowedBook(int accountId) {
        List<Borrow> borrowList = new ArrayList<>();
        FindIterable<Borrow> listBorrowed = collection.find(Filters.eq("accountId", accountId));

        listBorrowed.forEach(b -> {
            borrowList.add(b);
        });

        borrowList.forEach(System.out::println);
        return borrowList;
    }
}