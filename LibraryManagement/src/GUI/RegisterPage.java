package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;

import javax.swing.*;

/**
 * Represents the register page of the application (Singleton).
 *
 * @author Edgrant Henderson Suryajaya
 */
public class RegisterPage implements Displayable {
    /*-----------------------------------------------Variables--------------------------------------------------------*/
    //editable Text

    private TextField username;
    private TextField password;
    private TextField passwordConfirm;

    /*----------------------------------------------------------------------------------------------------------------*/

    public void display() {
        SwingUtilities.invokeLater(() -> {
            BasePage basePage = new BasePage("Register Page");

            // Username and Password TextFields
            username = new TextField("username: ");
            basePage.add(username.create());

            password = new TextField("password: ");
            basePage.add(password.create());

            passwordConfirm = new TextField("confirm password: ");
            basePage.add(passwordConfirm.create());

            // Login button
            JButton loginButton = new JButton("Register");
            loginButton.addActionListener(e -> register());
            basePage.add(loginButton);

            basePage.render();
        });
    }


    private void register() {
        // Check if the username or password fields are empty
        String usernameString = username.getText().trim();
        String passwordString = password.getText().trim();
        String passwordConfirmString = passwordConfirm.getText().trim();

        //if input is empty
        if (usernameString.isEmpty() || passwordString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //if password doesn't match
        if (!passwordString.equals(passwordConfirmString)) {
            JOptionPane.showMessageDialog(null, "Password doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Register logic here
        Displayable.movePage(new LoginPage());
    }}
