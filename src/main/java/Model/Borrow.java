package Model;


/**
 * The {@code Borrow} class represents a borrowing transaction, containing information about
 * the associated account, book, borrow status, borrow time, and return time.
 * <p>
 * This class extends the {@link Model.Serializable} class to support serialization.
 * </p>
 *
 * @author Darmawan Hanif
 */
public class Borrow extends Serializable {

    /**
     * The ID of the account associated with the borrowing transaction.
     */
    public int accountId;

    /**
     * The ID of the book associated with the borrowing transaction.
     */
    public int bookId;

    /**
     * The status of the borrowing transaction, represented by {@link BorrowStatus}.
     */
    public BorrowStatus borrowStatus;

    /**
     * The time when the book was borrowed.
     */
    private String borrowTime;

    /**
     * The time when the book is expected to be returned.
     */
    private String returnTime;

    /**
     * Default constructor for the {@code Borrow} class.
     * <p>
     * Initializes the borrowing transaction with default values.
     * </p>
     */
    public Borrow() {
        super();
    }

    /**
     * Retrieves the ID of the account associated with the borrowing transaction.
     *
     * @return The ID of the account.
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Sets the ID of the account associated with the borrowing transaction.
     *
     * @param accountId The new account ID to be set.
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * Retrieves the ID of the book associated with the borrowing transaction.
     *
     * @return The ID of the book.
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Sets the ID of the book associated with the borrowing transaction.
     *
     * @param bookId The new book ID to be set.
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * Retrieves the status of the borrowing transaction.
     *
     * @return The status of the borrowing transaction.
     */
    public BorrowStatus getBorrowStatus() {
        return borrowStatus;
    }

    /**
     * Sets the status of the borrowing transaction.
     *
     * @param borrowStatus The new status to be set.
     */
    public void setBorrowStatus(BorrowStatus borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    /**
     * Sets the time when the book was borrowed.
     *
     * @param borrowTime The new borrow time to be set.
     */
    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    /**
     * Sets the time when the book is expected to be returned.
     *
     * @param returnTime The new return time to be set.
     */
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * Marks the book as returned, updating the borrow status to {@link BorrowStatus#RETURNED}.
     */
    public void bookIsReturned() {
        this.borrowStatus = BorrowStatus.RETURNED;
    }

    /**
     * Marks the book as lost, updating the borrow status to {@link BorrowStatus#LOST}.
     */
    public void bookIsLost() {
        this.borrowStatus = BorrowStatus.LOST;
    }

    /**
     * Retrieves the time when the book was borrowed.
     *
     * @return The borrow time.
     */
    public String getBorrowTime() {
        return this.borrowTime;
    }

    /**
     * Retrieves the time when the book is expected to be returned.
     *
     * @return The return time.
     */
    public String getReturnTime() {
        return this.returnTime;
    }
}
