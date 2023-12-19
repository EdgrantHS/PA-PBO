package GUI;

import Model.Account;
import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.Row;
import javax.swing.*;

public class MyAccountPage implements Displayable{
    /*-----------------------------------------------Variables--------------------------------------------------------*/
    /**
     * The username text.
     */
    public String usernameText;

    /**
     * The name text.
     */
    public String nameText;

    /**
     * The email text.
     */
    public String emailText;

    /**
     * The rating text.
     */
    public int ratingText;

    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Displays the account page.
     */
    public MyAccountPage(Account account) {
        // Set the details from the account object
        this.usernameText = account.getUsername();
        this.nameText = account.getName();
        this.emailText = account.getEmail();
        this.ratingText = account.rating;
    }


    /**
     * Displays the account page.
     */
    @Override
    public void display() {
        SwingUtilities.invokeLater(() -> {
            BasePage basePage = new BasePage("Account Page");

            /*--------------------------------------------------------------------------------------------------------*/
            // Component setup
            Row usernameRow = new Row("Username: ", usernameText);
            basePage.add(usernameRow.create());

            Row nameRow = new Row("Name: ", nameText);
            basePage.add(nameRow.create());

            Row emailRow = new Row("Email: ", emailText);
            basePage.add(emailRow.create());

            Row ratingRow = new Row("Rating: ", String.valueOf(ratingText));
            basePage.add(ratingRow.create());

            basePage.render();
        });
    }

}
