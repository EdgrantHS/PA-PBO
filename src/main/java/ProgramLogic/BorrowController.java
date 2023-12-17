package ProgramLogic;

import Model.Borrow;
import com.mongodb.client.MongoCollection;
import db.MongoDB;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowController {

    public static MongoCollection<Borrow> collection = MongoDB.getDatabaseInstance().getCollection("Borrow", Borrow.class);

    public static boolean rentBook(int accountId, int bookId, String returnDate) {
        // Check if returnDate > current date
        if (isReturnDateValid(returnDate)) {
            // Check if the book is available
            if (isBookAvailable(bookId)) {
                // Perform booking
                Borrow borrow = new Borrow(accountId, bookId, getTimestampFromString(returnDate));
                collection.insertOne(borrow);
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
    private static boolean isReturnDateValid(String returnDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            Date parsedReturnDate = dateFormat.parse(returnDate);
            return parsedReturnDate.after(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isBookAvailable(int bookId) {
        // asumsi : buku avai, alwys
        return true;
    }

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

    public static List<Borrow> handleGetBook() {
        //logika handle get book di sini
        return collection.find().into(new ArrayList<>());
    }
}