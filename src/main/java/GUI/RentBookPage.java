package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;
import ProgramLogic.BorrowController;

import javax.swing.*;

/**
 * Represents the rent book page of the application (Singleton).
 *
 * @author Edgrant Henderson Suryajaya
 */
public class RentBookPage implements Displayable {

    /*-----------------------------------------------Variables--------------------------------------------------------*/
    //editable Text

    private TextField returnDate;

    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Displays the rent book page.
     */
    public void display() {
        SwingUtilities.invokeLater(() -> {
            BasePage basePage = new BasePage("Rent Book Page");

            // Username and Password TextFields
            returnDate = new TextField("Return Date: ");
            basePage.add(returnDate.create());

            // Login button
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(e -> handleBorrowBook(basePage.getFrame()));
            basePage.add(submitButton);

            basePage.render();
        });
    }


    /**
     * Handles the login button.
     *
     * @param frame The current JFrame.
     */
    private void handleBorrowBook(JFrame frame) {
        String returnDateString = returnDate.getText().trim();

        //if input is empty
        if (returnDateString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //borrow the book
        // BorrowController.borrowBook(returnDateString, LoginPage.loggedAccount, BookPage.selectedBook);

        Displayable.movePage(frame, new MainPage());
    }
}