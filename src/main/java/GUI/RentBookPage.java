package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;
import Model.Account;
import Model.Borrow;
import ProgramLogic.AccountController;
import ProgramLogic.BorrowController;
import com.mongodb.client.MongoCollection;
import com.sun.tools.javac.Main;
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
            JButton loginButton = new JButton("Submit");
            loginButton.addActionListener(e -> handleBook(basePage.getFrame()));
            basePage.add(loginButton);

            basePage.render();
        });
    }


    private void handleBook(JFrame frame) {
        // Check if the username or password fields are empty
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