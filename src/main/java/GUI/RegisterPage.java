package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;
import ProgramLogic.AccountController;

import javax.swing.*;

/**
 * Represents the register page of the application.
 *
 * @author Edgrant Henderson Suryajaya
 */
public class RegisterPage implements Displayable {
    /*-----------------------------------------------Variables--------------------------------------------------------*/
    //editable Text

    /**
     * Represents the username TextField.
     */
    private TextField username;

    /**
     * Represents the name TextField.
     */
    private TextField name;

    /**
     * Represents the email TextField.
     */
    private TextField email;

    /**
     * Represents the password TextField.
     */
    private TextField password;

    /**
     * Represents the password confirmation TextField.
     */
    private TextField passwordConfirm;

    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Displays the register page.
     */
    public void display() {
        SwingUtilities.invokeLater(() -> {
            BasePage basePage = new BasePage("Register Page", "no menu");

            // Username and Password TextFields
            username = new TextField(       "Username:                 ");
            basePage.add(username.create());

            // padding
            JPanel paddingSmol = new JPanel();
            paddingSmol.add(Box.createVerticalStrut(5));
            basePage.add(paddingSmol);

            name = new TextField(           "Full Name:                  ");
            basePage.add(name.create());

            // padding
            basePage.add(paddingSmol);

            email = new TextField(          "Email:                          ");
            basePage.add(email.create());

            // padding
            basePage.add(paddingSmol);

            password = new TextField(       "Password:                 ");
            basePage.add(password.create());

            // padding
            basePage.add(paddingSmol);

            passwordConfirm = new TextField("Confirm Password: ");
            basePage.add(passwordConfirm.create());

            // padding
            basePage.add(paddingSmol);

            // padding
            JPanel paddingBig = new JPanel();
            paddingBig.add(Box.createVerticalStrut(20));
            basePage.add(paddingBig);

            // Login button
            JButton loginButton = new JButton("Register");
            loginButton.addActionListener(e -> register(basePage.getFrame()));
            basePage.add(loginButton);


            basePage.render();
        });
    }

    /**
     * Attempts to register a new account.
     *
     * @param frame The current JFrame.
     */
    private void register(JFrame frame) {
        String usernameString = username.getText().trim();
        String nameString = name.getText().trim();
        String emailString = email.getText().trim();
        String passwordString = password.getText().trim();
        String passwordConfirmString = passwordConfirm.getText().trim();

        //if input is empty
        if (usernameString.isEmpty() || passwordString.isEmpty() || passwordConfirmString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!passwordString.equals(passwordConfirmString)) {
            JOptionPane.showMessageDialog(null, "Password and password confirmation do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (AccountController.register(usernameString, nameString, emailString, passwordString)) {
            // Successful registration
            JOptionPane.showMessageDialog(null, "Registration successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
            Displayable.movePage(frame, new LoginPage());
        } else {
            // Failed registration (username already taken)
            JOptionPane.showMessageDialog(null, "Username already taken. Please choose another one.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
