package Model;

import java.sql.Timestamp;

public class Borrow extends Serializable {
    public int accountId;
    public int bookId;
    public BorrowStatus borrowStatus;
    private Timestamp borrowTime;
    private Timestamp returnTime;

    public Borrow(int accountId, int bookId, Timestamp returnTime) {
        super();
        this.accountId = accountId;
        this.bookId = bookId;
        this.returnTime = returnTime;
        this.borrowTime = new Timestamp(System.currentTimeMillis());
        this.borrowStatus = BorrowStatus.BORROWED;
    }

    public void bookIsReturned() {
        this.borrowStatus = BorrowStatus.RETURNED;
    }

    public void bookIsLost() {
        this.borrowStatus = BorrowStatus.LOST;
    }

    public Timestamp getBorrowTime() {
        return this.borrowTime;
    }

    public Timestamp getReturnTime() {
        return this.returnTime;
    }
}
