package ProgramLogic;

import Model.Borrow;
import com.mongodb.client.MongoCollection;
import db.MongoDB;

public class BorrowController {
    public static MongoCollection<Borrow> collection = MongoDB.getDatabaseInstance().getCollection("Borrow", Borrow.class);

    //public static List<Borrow> getBorrowByAccount(int accountId) {}
}
