package GUI;

import GUI.SubGUIModel.BasePage;
import GUI.SubGUIModel.TextField;

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

            // Login button
            JButton loginButton = new JButton("Login");
            loginButton.addActionListener(e -> login(basePage.getFrame()));
            basePage.add(loginButton);

            // Register button
            JButton registerButton = new JButton("Register");
            registerButton.addActionListener(e -> register(basePage.getFrame()));
            basePage.add(registerButton);

            basePage.render();
        });
    }

    private void login(JFrame frame) {
        // Check if the username or password fields are empty
        if (username.getText().trim().isEmpty() || password.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Login logic here

        //
        if(
                true
                //membuat checking login
        ){
            Displayable.movePage(frame, new MainPage());
        }

    }

    private void register(JFrame frame) {
        // Check if the username or password fields are empty
        String usernameString = username.getText().trim();
        String passwordString = password.getText().trim();

        // Register logic here
        Displayable.movePage(frame, new RegisterPage());
    }
}
