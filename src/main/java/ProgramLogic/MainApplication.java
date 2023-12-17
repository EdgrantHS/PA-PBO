package ProgramLogic;

import GUI.*;

import javax.swing.*;

import static GUI.Displayable.movePage;

/**
 * The main application class responsible for launching the application and managing page transitions.
 * This class creates a Swing window and initializes the login and register pages.
 * It also provides a starting point for the application.
 *
 * @author Edgrant Henderson Suryajaya
 */
public class MainApplication {
    public static void main(String[] args) {

        movePage(new JFrame(), new LoginPage());
        BookController.booksObserver();
    }
}
