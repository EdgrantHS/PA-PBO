package Model;

/**
 * The {@code BorrowStatus} enum represents the status of a book borrowing transaction.
 * It can have one of the following values: {@code BORROWED}, {@code RETURNED}, or {@code LOST}.
 *
 * @author Darmawan Hanif
 */
public enum BorrowStatus {

    /**
     * Represents the status when a book is currently borrowed by a user.
     */
    BORROWED,

    /**
     * Represents the status when a borrowed book has been returned.
     */
    RETURNED,

    /**
     * Represents the status when a borrowed book is marked as lost.
     */
    LOST
}
