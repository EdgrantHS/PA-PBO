package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;
import Model.Account;
import Model.Borrow;
import ProgramLogic.AccountController;
import ProgramLogic.BorrowController;
import com.mongodb.client.MongoCollection;
import ProgramLogic.BorrowController;
import db.MongoDB;

import javax.swing.*;

/**
 * Represents the rent book page of the application.
 *
 * @author Edgrant Henderson Suryajaya
 */
public class RentBookPage implements Displayable {

    /*-----------------------------------------------Variables--------------------------------------------------------*/
    //editable Text
    public static MongoCollection<Borrow> collection = MongoDB.getDatabaseInstance().getCollection("Borrow", Borrow.class);
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

        // Register logic here
        // DAPET BOOOK ID DR MANA, silakan dipikirkan sendiri
        BorrowController.rentBook(AccountController.loggedInAccount.id, MainPage.clickedBookId, returnDateString);
        Displayable.movePage(frame, new MainPage());
    }
}