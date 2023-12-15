package GUI.SubGUIModel;

import GUI.MainPage;
import GUI.MyAccountPage;

import javax.swing.*;
import java.awt.*;

import static GUI.Displayable.movePage;

/**
 * A navigation bar that allows users to navigate between different pages in the library management system.
 *
 * @author Edgrant
 * @version 1.0
 * @since 2023-03-08
 */
public class NavigationBar extends JPanel {

    /**
     * The frame that contains the navigation bar.
     */
    private final JFrame frame;

    /**
     * Creates a new navigation bar.
     *
     * @param frame The frame that contains the navigation bar.
     */
    public NavigationBar(JFrame frame) {
        this.frame = frame;
        createNavigationBar();
    }

    /**
     * Creates the navigation bar.
     */
    private void createNavigationBar() {

        // Create buttons for navigation choices
        JButton homeButton = new JButton("Home");
        JButton accountPageButton = new JButton("Account Page");
        JButton rentedBooksButton = new JButton("Rented Books");

        // Align buttons to the right using FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        buttonPanel.add(homeButton);
        buttonPanel.add(accountPageButton);
        buttonPanel.add(rentedBooksButton);

        // Add the buttonPanel to this NavigationBar
        this.add(buttonPanel);

        // Add action listeners to the buttons (customize these)
        homeButton.addActionListener(e -> {
            // Handle Home button click
//            JOptionPane.showMessageDialog(frame, "Home button clicked");
            movePage(frame, new MainPage());
        });

        accountPageButton.addActionListener(e -> {
            // Handle Model.Account Page button click
//            JOptionPane.showMessageDialog(frame, "Model.Account Page button clicked");
            movePage(frame, new MyAccountPage());
        });

        rentedBooksButton.addActionListener(e -> {
            // Handle Rented Books button click
//            JOptionPane.showMessageDialog(frame, "Rented Books button clicked");
            movePage(frame, new MyAccountPage());
        });
    }
}
