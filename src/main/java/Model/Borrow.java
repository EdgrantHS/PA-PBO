package Model;

import java.sql.Timestamp;

public class Borrow extends Serializable {
    public int accountId;
    public int bookId;
    public BorrowStatus borrowStatus;
    private String borrowTime;
    private String returnTime;

    public Borrow() {
        super();
    }

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

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public void bookIsReturned() {
        this.borrowStatus = BorrowStatus.RETURNED;
    }

    public void bookIsLost() {
        this.borrowStatus = BorrowStatus.LOST;
    }

    public String getBorrowTime() {
        return this.borrowTime;
    }

    public String getReturnTime() {
        return this.returnTime;
    }
}
