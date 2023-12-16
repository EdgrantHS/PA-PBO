package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;
import ProgramLogic.AccountController;

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
    private TextField name;
    private TextField email;
    private TextField password;
    private TextField passwordConfirm;

    /*----------------------------------------------------------------------------------------------------------------*/

    public void display() {
        SwingUtilities.invokeLater(() -> {
            BasePage basePage = new BasePage("Register Page", "no menu");

            // Username and Password TextFields
            username = new TextField("username: ");
            basePage.add(username.create());

            name = new TextField("username: ");
            basePage.add(name.create());

            email = new TextField("email: ");
            basePage.add(email.create());

            password = new TextField("password: ");
            basePage.add(password.create());

            passwordConfirm = new TextField("confirm password: ");
            basePage.add(passwordConfirm.create());

            // Login button
            JButton loginButton = new JButton("Register");
            loginButton.addActionListener(e -> register(basePage.getFrame()));
            basePage.add(loginButton);

            basePage.render();
        });
    }


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
