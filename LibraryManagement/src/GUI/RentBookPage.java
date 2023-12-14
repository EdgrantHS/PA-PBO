package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;
import com.sun.tools.javac.Main;

import javax.swing.*;

/**
 * Represents the register page of the application (Singleton).
 *
 * @author Edgrant Henderson Suryajaya
 */
public class RentBookPage implements Displayable {
    /*-----------------------------------------------Variables--------------------------------------------------------*/
    //editable Text

    private TextField returnDate;

    /*----------------------------------------------------------------------------------------------------------------*/

    public void display() {
        SwingUtilities.invokeLater(() -> {
            BasePage basePage = new BasePage("Register Page");

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
        Displayable.movePage(frame, new MainPage());
    }}
