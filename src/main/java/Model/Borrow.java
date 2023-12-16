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

    public Borrow() {super();};

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public BorrowStatus getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(BorrowStatus borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public void bookIsReturned() {
        this.borrowStatus = BorrowStatus.RETURNED;
    }

    public void bookIsLost() {
        this.borrowStatus = BorrowStatus.LOST;
    }
}
