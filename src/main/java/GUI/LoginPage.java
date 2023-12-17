package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;
import ProgramLogic.AccountController;

import javax.swing.*;

/**
 * Represents the login page of the application (Singleton).
 *
 * @author Edgrant Henderson Suryajaya
 */
public class LoginPage implements Displayable{
    /*-----------------------------------------------Variables--------------------------------------------------------*/
    //editable Text
    // jangan lupa tambahin static account untuk nyimpen account yang kelog in
    private TextField username;
    private TextField password;

    /*----------------------------------------------------------------------------------------------------------------*/

    public void display() {
        SwingUtilities.invokeLater(() -> {
            BasePage basePage = new BasePage("Login Page", "no menu");

            // Username and Password TextFields
            username = new TextField("username: ");
            basePage.add(username.create());

            password = new TextField("password: ");
            basePage.add(password.create());

            // padding
            JPanel padding = new JPanel();
            padding.add(Box.createVerticalStrut(20));
            basePage.add(padding);

            // Login button
            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(e -> login(basePage.getFrame()));
            loginButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            basePage.add(loginButton);

            // padding
            JPanel padding2 = new JPanel();
            padding2.add(Box.createVerticalStrut(5));
            basePage.add(padding2);

            // Register button
            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(e -> register(basePage.getFrame()));
            registerButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
            basePage.add(registerButton);

            basePage.render();
        });
    }

    private void login(JFrame frame) {
        String usernameString = username.getText().trim();
        String passwordString = password.getText().trim();

        if (username.getText().trim().isEmpty() || password.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (AccountController.authenticate(usernameString, passwordString)) {
            // Successful login
            JOptionPane.showMessageDialog(null, "Login successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
            Displayable.movePage(frame, new MainPage());
        } else {
            // Failed login
            JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void register(JFrame frame) {
        Displayable.movePage(frame, new RegisterPage());
    }
}
